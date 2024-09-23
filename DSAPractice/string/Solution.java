package DSAPractice.string;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    //Function to check if brackets are balanced or not.
    public boolean ispar(String x){
        // add your code here

        int strLen = x.length();
        Stack<String> stack = new Stack<String>();

        for(int i=0; i<strLen; i++){
            if(String.valueOf(x.charAt(i)).equals("(") || String.valueOf(x.charAt(i)).equals("{") ||
                    String.valueOf(x.charAt(i)).equals("[")){
                stack.push(String.valueOf(x.charAt(i)));
            }else {
                if(stack.isEmpty())
                    return false;

                String latestFromStack = stack.peek();

                String toCheck = latestFromStack.equals("(") ? ")" : latestFromStack.equals("[") ? "]" : latestFromStack.equals("{") ? "}" : null;

                if(!String.valueOf(x.charAt(i)).equals(toCheck)){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            return true;

        return false;
    }

    public int isPalindrome(String S) {
        // code here

        int lastIndex = S.length()-1;

        for(int i=0; i< S.length()/2; i++){
            if(String.valueOf(S.charAt(i)).equals(String.valueOf(S.charAt(lastIndex)))){
                lastIndex--;
            }else {
                return 0;
            }
        }

        return 1;
    }

    //Function is to check whether two strings are anagram of each other or not.
    public boolean isAnagram(String a,String b) {
        // Your code here

        if(a.length() != b.length())
            return false;

        HashMap<String,Integer> aMap = new HashMap<>();
        HashMap<String,Integer> bMap = new HashMap<>();

        for(int i=0; i<a.length(); i++){
            if(aMap.containsKey(String.valueOf(a.charAt(i)))){
                aMap.put(String.valueOf(a.charAt(i)), aMap.get(String.valueOf(a.charAt(i))).intValue() + 1);
            }else {
                aMap.put(String.valueOf(a.charAt(i)), 1);
            }
        }

        for(int i=0; i<b.length(); i++){
            if(bMap.containsKey(String.valueOf(b.charAt(i)))){
                bMap.put(String.valueOf(b.charAt(i)), bMap.get(String.valueOf(b.charAt(i))).intValue() + 1);
            }else {
                bMap.put(String.valueOf(b.charAt(i)), 1);
            }
        }

        for (Map.Entry<String,Integer> entry: aMap.entrySet()){
            if(!bMap.containsKey(entry.getKey())){
                return false;
            }else {
                if(bMap.get(entry.getKey()).intValue() != entry.getValue()){
                    return false;
                }
            }
        }

        return true;

    }

    public String reverseWords(String S) {
        // code here
        String newString = "";

        String arrStr[] = S.trim().split("\\.");

        for(int i=arrStr.length-1; i>=0; i--){
           /*if(newString.isEmpty()){
               newString = arrStr[i];
           }else {
               newString = newString+"."+arrStr[i];
           }*/
            newString = newString.isEmpty() ? arrStr[i] : newString + "." + arrStr[i];
        }

        return newString;

    }

    public boolean isRotated(String str1, String str2){
        // Your code here

        if(str1.length() != str2.length())
            return false;

        String toCheckFromStart = str1.toLowerCase().substring(2,str1.length())+str1.toLowerCase().substring(0,2);

        if(toCheckFromStart.equals(str2))
            return true;

        String toCheckFromLast = str1.toLowerCase().substring(str1.length()-2,str1.length())+str1.toLowerCase().substring(0,str1.length()-2);

        if(toCheckFromLast.equals(str2))
            return true;

        return false;
    }

    public char nonrepeatingCharacter(String S) {

        //Your code here

        HashMap<Character,Integer> hashMap = new HashMap<>();

        char retrunChar = '$';

        for(int i=0; i<S.length(); i++){
            if(hashMap.containsKey(S.charAt(i))){
                hashMap.put(S.charAt(i), hashMap.get(S.charAt(i)).intValue()+1);
            }else {
                hashMap.put(S.charAt(i), 1);
            }
        }

        for(int i=0; i<S.length(); i++){
            if(hashMap.get(S.charAt(i)).intValue() == 1)
                return S.charAt(i);
        }

        return retrunChar;
    }

    //Function to check if two strings are isomorphic.
    public boolean areIsomorphic(String str1,String str2){
        // Your code here

        if(str1.length() != str2.length())
            return false;

        HashMap<String,Integer> str1Map = new HashMap<>();
        HashMap<String,Integer> str2Map = new HashMap<>();

        for(int i=0; i<str1.length(); i++){
            if(str1Map.containsKey(String.valueOf(str1.charAt(i))) && str2Map.containsKey(String.valueOf(str2.charAt(i)))){

                if(str1Map.get(String.valueOf(str1.charAt(i))).intValue() == str2Map.get(String.valueOf(str2.charAt(i))).intValue()){
                    str1Map.put(String.valueOf(str1.charAt(i)), i);
                    str2Map.put(String.valueOf(str2.charAt(i)), i);
                }else {
                    return false;
                }


            }else if(!str1Map.containsKey(String.valueOf(str1.charAt(i))) && !str2Map.containsKey(String.valueOf(str2.charAt(i)))){
                str1Map.put(String.valueOf(str1.charAt(i)), i);
                str2Map.put(String.valueOf(str2.charAt(i)), i);
            }else {
                return false;
            }
        }


        return true;
    }

    public int romanToDecimal(String str) {
        // code here
        int sum = 0;
        int n = str.length();

        for(int i=0; i<n; i++){
            if(i < n-1){
                int v1= valueOf(str.charAt(i));
                int v2= valueOf(str.charAt(i+1));
                if(v1<v2){
                    sum = sum-v1;
                }else {
                    sum = sum + v1;
                }

            }else {
                sum = sum + valueOf(str.charAt(n-1));
            }
        }

        return sum;
    }

    // This function returns value of a Roman symbol
    private int valueOf(char r) {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        if (r == 'M') return 1000;
        return -1;
    }

    //Function to check if two strings are rotations of each other or not.
    public boolean areRotations(String s1, String s2 ){
        // Your code here

        if(s1.length() != s2.length())
            return false;

        if(s1.equals(s2))
            return true;

        /*for (int i=1; i<=s2.length()-1; i++){
            String toCheck = s1.substring(i,s1.length())+s1.substring(0,i);
            if(toCheck.equals(s2)){
                return true;
            }


        }*/

        String concatedString = s1 + s1;

        if(concatedString.contains(s2))
            return true;

        return false;
    }

    public int longestSubstrDistinctChars(String S){
        int size = 0, l=0, r=0;

        int n = S.length();

        int hash[] = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = -1;
        }

        while (r < n){
            if(hash[S.charAt(r)] != -1){
               // l++;
                if(hash[S.charAt(r)] >= l){
                    l=hash[S.charAt(r)] + 1;
                }
            }
            hash[S.charAt(r)] = r;
            int len = r-l+1;
            size = Math.max(size,len);
            r++;
        }

        return size;
    }

    public String removeDups(String S) {
        // code here
        int n = S.length();

        int hash[] = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = -1;
        }

        String str = "";

        for(int i=0; i<S.length(); i++){
            if(hash[S.charAt(i)] == -1){
                hash[S.charAt(i)] = 1;
                str = str+S.charAt(i);
            }
        }

        return str;
    }

    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n) {
        // add your code

        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 1;

        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]).intValue() + 1);
            }else {
                map.put(arr[i],1);
            }
        }

        SortedSet<String> ts = new TreeSet<String>();

        for (Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue() > maxLen)
                maxLen = entry.getValue();
        }

        for (Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue() == maxLen)
                ts.add(entry.getKey());
        }

        //String[] strings = new String[]{ts.first()};



        return new String[]{ts.first(), String.valueOf(maxLen)};
    }

    public static int minIndexChar(String str, String patt){
        // Your code here
        int minIndex = -1;

        for(int i=0; i<str.length(); i++){
            /*if(str.contains(String.valueOf(patt.charAt(i))) && minIndex != -1){
                minIndex = Integer.min(minIndex,str.indexOf(patt.charAt(i)));
            }else if(str.contains(String.valueOf(patt.charAt(i))) && minIndex == -1){
                minIndex = str.indexOf(patt.charAt(i));
            }*/

            if(patt.contains(String.valueOf(str.charAt(i)))){
                return i;
            }
        }

        return minIndex;

    }

    public String reverse(String S){
        //code here
        String newStr = "";

        Stack<String> stack = new Stack<>();

        for(int i=0; i<S.length(); i++){
            stack.push(String.valueOf(S.charAt(i)));
        }

        for(int i=0; i<S.length(); i++){
            newStr = newStr + stack.pop();
        }

        return newStr;
    }

    public String firstRepChar(String s){
        // code here
        String str = "-1";
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(String.valueOf(s.charAt(i)))){
                str = String.valueOf(s.charAt(i));
                break;
            }else {
                map.put(String.valueOf(s.charAt(i)),1);
            }
        }

        return str;
    }

    public boolean checkPangram  (String s) {
        // your code here

        if(s.length() < 26)
            return false;

        int hash[] = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = -1;
        }

        for(int i=0; i<s.length(); i++){
            if(hash[s.charAt(i)] == -1)
                hash[s.charAt(i)] = 1;
        }

        for(int i=97; i<=122; i++){
            if(hash[i] == -1)
                if(hash[i-32]==-1)
                    return false;
        }

        return true;
    }

    public String secFrequent(String arr[], int N){
        // your code here
        String secondMostRepeated = "";

        Map<String, Integer> map =  new HashMap<>();
        int maxOccurance = 0;
        int minOccurance = 0;

        for(int i=0; i<N; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]).intValue() + 1);
            }else {
                map.put(arr[i],1);
            }

            maxOccurance = Integer.max(maxOccurance, map.get(arr[i]).intValue());
        }

        for(Map.Entry<String, Integer> m: map.entrySet()){
            if(m.getValue() > minOccurance && m.getValue() < maxOccurance){
                secondMostRepeated = m.getKey();
                minOccurance = m.getValue();
            }
        }

        return secondMostRepeated;
    }

    public long ExtractNumber(String sentence) {
        // code here
        long largestNumber = -1;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(sentence);

        List<String> numbers = new ArrayList<>();

        while(matcher.find()){
            numbers.add(matcher.group());
        }

        for(String str: numbers){
            if(!str.contains("9")){
                long num = Long.parseLong(str);
                if(num > largestNumber)
                    largestNumber = num;
            }
        }

        return largestNumber;
    }

    public boolean areKAnagrams(String s1, String s2, int k) {
        // code here

        if(s1.length() != s2.length())
            return false;

        int diffCount = 0;

        for(int i=0; i<s1.length(); i++){
            if(!s2.contains(String.valueOf(s1.charAt(i)))){
                diffCount++;
            }else {
                int index = s2.indexOf(String.valueOf(s1.charAt(i)));
                String lPart = s2.substring(0,index);
                String rPart = s2.substring(index+1, s2.length());
                String str = lPart+"#"+rPart;

                s2 = str;
            }

            if(diffCount > k)
                return false;
        }

        return true;

        /*if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        for (char ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k)
            return false;
        else
            return true;*/
    }

    public String encode(String s) {
        // code here
        String encodedStr = "";

        int l=0,r=0, n=s.length();

        /*while (r <= n){
            int len = 0;
            len = r-l;

            if(r==n){
                encodedStr = encodedStr + s.charAt(l)+len;
                break;
            }

            if(s.charAt(l) != s.charAt(r)){
                encodedStr = encodedStr + s.charAt(l)+len;
                l = r;
            }
            r++;

        }*/


        /*while (r < n){
            if(s.charAt(l) == s.charAt(r)){
                r++;
            }else {
                int len = r-l;
                encodedStr = encodedStr + s.charAt(l)+len;
                l = r;
            }
        }
        int len = n-l;
        encodedStr = encodedStr + s.charAt(l)+len;
*/
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1
                    && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            encodedStr = encodedStr + s.charAt(i)+count;
            // Print character and its count
            //System.out.print(s.charAt(i) + "" + count);
        }



        return encodedStr;
    }

    public int smallestSubstring(String S) {
        // Code here
        int ans = -1;

        int n=S.length(), r=0, l=0;
        int zero=0, one=0, two=0;

        for(r=0; r<n; r++){

            if(String.valueOf(S.charAt(r)).equals("0")){
                zero++;
            }else if(String.valueOf(S.charAt(r)).equals("1")){
                one++;
            }else {
                two++;
            }

            while (one >=1 && two >= 1 && zero >= 1){
                if(ans == -1){
                    ans = r-l+1;
                }else {
                    ans = Integer.min(ans, r-l+1);
                }

                if(String.valueOf(S.charAt(l)).equals("0")){
                    zero--;
                }else if(String.valueOf(S.charAt(l)).equals("1")){
                    one--;
                }else {
                    two--;
                }

                l++;
            }
        }

        return ans;
    }

    public void recursionBack(int n){

        recur(1,n);

    }
    public void recur(int n1,int n2){
        if(n1 > n2){
            return;
        }

        recur(n1+1, n2);

        System.out.print(n1);
    }

    public void longestSubarrayWithoutRepeatatingChars(int[] charArr){

        int left = 0, right = 0;
        int len = charArr.length;
        int[] hash = new int[256];
        int maxLen = 0;

        for(int i=0; i<256; i++){
            hash[i] = -1;
        }

        while(right<len){
            if(hash[charArr[right]] != -1){
                if(hash[charArr[right]] >= left){
                    left = hash[charArr[right]]+1;
                }
            }

            maxLen = Integer.max(maxLen, right-left+1);
            hash[charArr[right]] = charArr[right];
            right++;
        }

        System.out.println("maxLength "+maxLen);
    }

    public void maxConsecutiveOnes(int[] arr, int k){

        int left = 0, right = 0;
        int len = arr.length;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < len){

            if(arr[right] == 0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(arr[left] == 0) {
                    zeroCount--;
                }

                left++;
            }
            /*while (zeroCount > k){
                if(arr[left] == 0) {
                    zeroCount--;
                }

                left++;
            }*/

            if(zeroCount <= k){
                maxLen = Integer.max(maxLen,right-left+1);
            }
            right++;
        }

        System.out.println("Maxlength "+maxLen);
    }

    public void substringWithKMostDistChar(char[] arr, int k){

        int left = 0, right = 0, len = arr.length;
        Map<Character,Integer> characterMap = new HashMap<>();
        int maxLen = 0;

        while (right < len){
            if(characterMap.get(arr[right]) == null){
                characterMap.put(arr[right],1);
            }else {
                characterMap.put(arr[right],characterMap.get(arr[right])+1);
            }

            if(characterMap.size() > k){
                characterMap.put(arr[left],characterMap.get(arr[left])-1);
                if(characterMap.get(arr[left]) == 0){
                    characterMap.remove(arr[left]);
                }
                left++;
            }

            /*while (characterMap.size() > k){
                characterMap.put(arr[left],characterMap.get(arr[left])-1);
                if(characterMap.get(arr[left]) == 0){
                    characterMap.remove(arr[left]);
                }
                left++;
            }*/

            if(characterMap.size() <= k){
                maxLen = Integer.max(maxLen,right-left+1);
            }

            right++;
        }

        System.out.println("MaxLength "+maxLen);
    }

    public void noOfSubstringHasAllChars(char[] arr){
        int[] lastSeenHash = new int[]{-1,-1,-1};
        int count = 0;

        for(int i=0; i<arr.length; i++){
            lastSeenHash[arr[i] - 'a'] = i;

            if(lastSeenHash[0] != -1 && lastSeenHash[1] != -1 && lastSeenHash[2] != -1){
                int minimum = Integer.min(Integer.min(lastSeenHash[0],lastSeenHash[1]),lastSeenHash[2]);
                count = count + 1 + minimum;
            }
        }

        System.out.println("Count "+count);
    }

    public void longestRepeatingCharReplaceToGetSameChars(char[] arr, int k){
        int left = 0, right = 0, len = arr.length;
        int maxFrequency = 0;
        int maxLen = 0;
        int[] hash = new int[26];
        for(int i=0; i<26; i++){
            hash[i] = 0;
        }

        while (right < len){
            hash[arr[right] - 'A']++;
            maxFrequency = Integer.max(maxFrequency, hash[arr[right] - 'A']);

            if((right-left+1) - maxFrequency > k){

                hash[arr[right] - 'A']--;
                left++;
            }

            if((right-left+1) - maxFrequency <= k){
                maxLen = Integer.max(maxLen, right-left+1);
            }
            right++;
        }

        System.out.println("Maxlength "+maxLen);
    }

    public void binarySubArraysToFindSum(int[] arr, int sum){

        int count = findSubArrays(arr,sum) - findSubArrays(arr,sum-1);

        System.out.println("Count "+count);

    }
    private int findSubArrays(int[] arr, int k){
        int count = 0;
        int left = 0, right = 0;
        int sum = 0;

        if(k < 0) return 0;

        while (right < arr.length){
            sum = sum+ arr[right];

            while (sum > k){
                sum = sum-arr[left];
                left++;
            }

            count = count + (right-left+1);
            right++;
        }

        return count;
    }

    //calculate the min length of subarray in arr consisting all value of subArr
    public void minLengthSubstring(char[] arr, char[] subArr){

        int len = arr.length;
        int subArrayLen = subArr.length;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        int[] hash = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = 0;
        }

        while (right < len){
            if(hash[arr[right]] == 0){
                count++;
            }
            hash[arr[right]]++;

            while (count == subArrayLen){
                minLen = Integer.min(minLen, right-left+1);

                hash[arr[left]]--;
                if(hash[arr[left]] == 0)
                    count = count - 1;
                left = left + 1;

            }

            right = right + 1;

        }


        System.out.println("Min length "+minLen);
    }
}
