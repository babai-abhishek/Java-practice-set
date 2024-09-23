package gfg.array;

import java.util.*;

public class Solution {

    static ArrayList<Integer> list = new ArrayList<>();

    public void missingNumber(int[] array, int n) {

        //System.out.println(Arrays.asList(array));
        // Your Code Here
        int sum = 0;
        for (int i = 1; i <=n;i++){
            sum += i;
        }

        int sumArray = 0;
        for (int i = 0 ; i < array.length; i++){
            sumArray += array[i];
        }

        int missing = sum - sumArray;

        System.out.println("missing number "+ missing);
    }

    public ArrayList<Integer> duplicates(int arr[], int n) {
        // code here

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<arr.length ; i++){

            int count = map.get(Integer.valueOf(arr[i])) == null ? Integer.valueOf(1) : map.get(Integer.valueOf(arr[i]));

            if(map.containsKey(arr[i])){
                map.put(arr[i],Integer.valueOf(++count));
            }else {
                map.put(arr[i],1);
            }

        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer,Integer> en : map.entrySet()){
            if(en.getValue() > 1){
                list.add(en.getKey());
            }
        }

        Collections.sort(list);

        if (list.isEmpty()) {

            list.add(-1);
        }

        return list;
    }
    public static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here

        if(arr.length > 0 ) {

            int max = arr[0];

            // int i=0;
            if (arr.length - 1 > 0) {
                int pos = 0;
                for (int j = 1; j <= arr.length - 1; j++) {

                    if (max < arr[j]) {
                        max = arr[j];
                        pos = j;
                    }
                }
                list.add(max);


                leaders(Arrays.copyOfRange(arr, pos + 1, arr.length), n);
            }else
                list.add(arr[arr.length - 1]);
        }
        return list;
    }

    public int equilibriumPoint(long arr[], int n) {

        // Your code here

        int sum = 0;
        int leftSum = 0;

        for(int i = 0 ; i<n ; i++)
            sum += arr[i];


        for(int i=0 ; i<n ; i++){
            sum -= arr[i];

            if(sum == leftSum)
                return i;

            leftSum += arr[i];
        }

        return -1;
    }

    public int print2largest(int arr[], int n) {
        // code here
        Set<Integer> integerSet = new TreeSet<>();
        for(int i=0; i<n; i++){
            integerSet.add(Integer.valueOf(arr[i]));
        }

        int secondLast = -1;

        if(integerSet.size() == 1)
            return -1;
        else {
            int currentIndex = 1;
            for(Integer in: integerSet){

                if(currentIndex == integerSet.size() - 1){
                    secondLast = in;
                }

                currentIndex++;
            }
        }

        return secondLast;
    }

    public int getPairsCount(int[] arr, int n, int k) {
        int count = 0;

        HashMap <Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<n; i++){

            if(hmap.containsKey(k-arr[i])){
                count += hmap.get(k-arr[i]);
            }

            if(!hmap.containsKey(arr[i]))
                hmap.put(arr[i],1);
            else
                hmap.put(arr[i], hmap.get(arr[i])+1);

           /* if(hmap.containsKey(k-arr[i])){
                count += hmap.get(k-arr[i]);
            }*/

        }
        return count;
    }

    public void twoSum(int[] arr, int n, int k){

    // n=5 k=14 arr = {7,6,3,8,2}
    // output = 1,3

    HashMap<Integer, Integer> integerHashMap = new HashMap<>();

    for(int i=0; i<n; i++){

        int needToSrch = k - arr[i];

        if(!integerHashMap.containsKey(needToSrch)){
            integerHashMap.put(arr[i],i);
        }else {
            System.out.println(integerHashMap.get(needToSrch).intValue()+" "+i);
        }
    }

    }

    public void smallestNumberWhoseProductOfDigitsIsN(int n){

        //input = 1000
        //output = 5558

        //Hint : prime factorial

        String smallestNumber = "";

        for(int i=9; i>=2; i--){
            while(n%i == 0){
                n=n/i;
                smallestNumber = i+smallestNumber;

            }
        }

        if(n != 1){
            System.out.println("Prime number");
            return;
        }



        System.out.println(Integer.parseInt(smallestNumber));

    }

    public void threeSumTriplet(int arr[], int n, int target){

        //input: {2,4,2,4,0,5,6,2} 8 8 , calculate the combinations of 3 to get 8
        //output: 0 2 6  0 4 4  2 2 4
        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if (i==0 || (arr[i] != arr[i-1])) {
                int j = i + 1;
                int k = n - 1;
                target = target - arr[i];

                while (j<k) {
                    if (arr[j] + arr[k] == target) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
                        while (j < k && arr[j] == arr[j + 1]) j++;
                        while (j < k && arr[k] == arr[k - 1]) k--;
                        j++;
                        k--;
                    } else if (arr[j] + arr[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }

        }

    }

    public void majorityCandidate(int arr[], int n){

        //input: 1,2,3,1,5,1,1 condition is frequency > n/2
        //output: 1

        int selected = arr[0];
        int count = 1;

        for(int i=1; i<n; i++){
            if(selected == arr[i]){
                count++;
            }else {
                count--;
                if(count == 0){
                    selected = arr[i];
                    count++;
                }
            }
        }

        count = 0;
        for(int integer: arr){
            if(selected == integer){
                count ++;
            }
        }

        if(count > n/2){
            System.out.println(selected);
        }else {
            System.out.println(-1);
        }

    }

    public void rotateArr(int arr[], int d, int n) {
        //input: 1,2,3,4,5 d=2
        //output: 3,4,5,1,2

        d = d%n;
        // add your code here
        reverse(arr,0,d-1);

        reverse(arr, d, n-1);

        reverse(arr, 0, n-1);

        for(int i=0; i<n; i++){
            System.out.print(arr[i]);
        }

    }

    public static void reverse(int arr[], int start, int end){

        while (start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        /*List<Integer> ints = new ArrayList<>();

        for(int i=0; i<n; i++){
            ints.add(arr[i]);
        }

        for (Integer integer: ints){
            int gap = x - integer;
            if (ints.contains(gap)){

                return true;
            }
        }
*/
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++){
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]).intValue()+1);
            }else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){

            int difference = x - entry.getKey();
            if(difference == entry.getKey() && entry.getValue() > 1){
                return true;
            }else if(difference != entry.getKey() && map.containsKey(difference)){
                return true;
            }
        }

        return false;
    }

    int transitionPoint(int arr[], int n) {
        // code here

        for(int i=1; i<n; i++){
            if(arr[i] ==1 && arr[i-1] == 0){
                return i;
            }
        }

        return -1;
    }

    public void frequencyCount(int arr[], int N, int P) {
        // code here
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<N; i++){
            if(hmap.containsKey(arr[i])){
                hmap.put(arr[i], hmap.get(arr[i]).intValue() + 1);
            }else {
                hmap.put(arr[i], 1);
            }
        }

        for(int i=0; i<N; i++){
            if(hmap.containsKey(i+1)){
                arr[i] = hmap.get(i+1).intValue();
            }else {
                arr[i] = 0;
            }
        }

        System.out.println(arr);
    }

    public String longestCommonPrefix(String arr[], int n){
        // code here

        //Arrays.sort(arr);
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        String selected = arr[0];

        if(selected.length() == 1){

            for(int j=1; j<arr.length; j++){
                if(!arr[j].contains(selected)){
                    return "-1";
                }
            }
            return selected;
        }

        List<String> possiblePrefix = new ArrayList<>();

        for(int i=1; i<selected.length(); i++){
            String prefix = selected.substring(0,i+1);

            for(int j=1; j<n;){
                String compareAgainst = arr[j];

                if(!compareAgainst.contains(prefix)){
                    break;
                }else{
                    if(j == n-1){
                        possiblePrefix.add(prefix);
                        break;
                    }
                    j++;

                }
            }
        }

        if(possiblePrefix.isEmpty()){
            return "-1";
        }else if(possiblePrefix.size() ==1){
            return possiblePrefix.get(0);
        }

        String maxLen = "";

        for (int i = 0; i < possiblePrefix.size(); i++) {

            if (i < possiblePrefix.size() - 1 && possiblePrefix.get(i).length() < possiblePrefix.get(i + 1).length()) {
                maxLen = possiblePrefix.get(i + 1);
            }
        }

        return maxLen;
    }

    public void convertToWave(int n, int[] a) {
        // code here
        Arrays.sort(a);

        for(int i=0; i<n;){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;

            if(i != n-1)
                i=i+2;

            if( i == n-1)
                break;
        }

        for (int i=0; i<n; i++){
            System.out.print(a[i]+" ");
        }
    }

    public int firstRepeated(int[] arr, int n) {
        // Your code here

        List<Integer> duplicateList = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                duplicateList.add(arr[i]);

            }else {
                map.put(arr[i],i+1);
            }
        }

        if(!duplicateList.isEmpty()){
            for(int i=0; i<n; i++){
                if(duplicateList.contains(arr[i]))
                    return i+1;
            }
        }

        return -1;
    }

    public int minDist(int a[], int n, int x, int y) {
        // code here
        int xpos = -1, ypos = -1;
        int min_distance = Integer.MAX_VALUE;


        for(int i=0; i<n; i++){
            if(a[i] == x){
                xpos = i+1;
            }

            if(a[i] == y){
                ypos = i+1;
            }

            if(xpos != -1 && ypos != -1){
                min_distance = Math.min(min_distance, Math.abs(xpos-ypos));
            }
        }

        if(min_distance == Integer.MAX_VALUE)
            return -1;
        else
            return min_distance;
    }

    public int remove_duplicate(int a[],int n){
        // code here

        if(n==0 || n==1)
            return 1;

        int temp[] = new int[a.length];
        int j=0;

        for(int i=0; i<n-1; i++){
            if(a[i] != a[i+1]){
                temp[j++] = a[i];
            }
        }


        temp[j++] = a[n-1];

        for (int i = 0; i < j; i++)
            a[i] = temp[i];


        return j;
    }

    public int Maximize(int arr[], int n){
        // Complete the function

        Arrays.sort(arr);
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += i*arr[i];
        }

        return sum;
    }

    public long[] productExceptSelf(int nums[], int n){
        // code here
        long[] p = new long[n];

        long mul = 1;
        // boolean zeroFound = false;
        int zeroCount = 0;

        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                mul = mul * nums[i];
            }else {
                //zeroFound = true;
                zeroCount++;
            }
        }

        for(int i=0; i<n; i++){
            if(zeroCount == 0){
                long valueAtIndexI = mul / nums[i];
                p[i] = valueAtIndexI;
            }else {
                if(zeroCount <= 1){
                    if(nums[i] != 0){
                        p[i] = 0;
                    }else {
                        p[i] = mul;
                    }
                }else{
                    p[i] = 0;
                }
            }
        }

        return p;
    }

    public int firstElementKTime(int n, int k, int[] a) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(map.containsKey(a[i])){
                int prevCount = map.get(a[i]).intValue();
                int updatedCount = prevCount + 1;
                map.put(a[i], updatedCount);

                if(updatedCount == k){
                    return a[i];
                }

            }else {
                map.put(a[i], i);
            }
        }

        return -1;
    }

    boolean arraySortedOrNot(int[] arr, int n) {
        // code here

        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1])
                return false;
        }

        return true;
    }

    public int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        int count = 0;

        Set<Integer> integerSet1 = new HashSet<>();
        for(int i=0; i<n; i++){
            integerSet1.add(a[i]);
        }
        Set<Integer> integerSet2 = new HashSet<>();
        for(int i=0; i<m; i++){
            integerSet2.add(b[i]);
        }

        for(Integer integer: integerSet1){
            if(integerSet2.contains(integer)){
                count++;
            }
        }

        return count;
    }

    public void pushZerosToEnd(int[] arr, int n) {
        // code here

        int temp[] = new int[n];

        int latestIndexOfTemp = n-1;
        int firstIndexOfTemp = 0;

        for(int i=0; i<n; i++){

            if(firstIndexOfTemp <= latestIndexOfTemp) {

                if (arr[i] != 0) {
                    temp[firstIndexOfTemp] = arr[i];
                    firstIndexOfTemp++;
                } else {
                    if (temp[latestIndexOfTemp] == 0) {
                        temp[latestIndexOfTemp] = 0;
                        latestIndexOfTemp--;
                    }else{
                        temp[latestIndexOfTemp] = 0;
                        temp[firstIndexOfTemp] = arr[i];
                        firstIndexOfTemp++;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }

    public int findKRotation(int arr[], int n) {
        // code here
        int count = 0;

        for(int i=0; i<n; i++){
            if(arr[i+1] > arr[i]){
                return count;
            }else {
                count++;
            }
        }


        return count;
    }

    public void rearrange(int arr[], int n) {
        // code here

        int lastIndexOfPositiveArr = 0;
        int lastIndexOfNegaitiveArr = 0;

        int[] positiveArray = new int[n];
        int[] negativeArray = new int[n];

        for(int i=0; i<n; i++){
            if(arr[i] < 0){
                negativeArray[lastIndexOfNegaitiveArr] = arr[i];
                lastIndexOfNegaitiveArr++;
            }else {
                positiveArray[lastIndexOfPositiveArr] = arr[i];
                lastIndexOfPositiveArr++;
            }
        }

        int i1=0, j=0, k=0;
        int temp[] = new int[n];

        for(int i=0; i<n; i++){
            if(i1<=lastIndexOfPositiveArr-1 && j<=lastIndexOfNegaitiveArr-1){
                arr[k++] = positiveArray[i1++];
                arr[k++] = negativeArray[j++];
            }
        }

        while(j<lastIndexOfNegaitiveArr)
            arr[k++] = negativeArray[j++];

        while(i1<lastIndexOfPositiveArr)
            arr[k++] = positiveArray[j++];

        System.out.println(arr);
    }

    public void threeWayPartition(int[] arr, int lowVal, int highVal){

        int start = 0, end = arr.length-1;

        for(int i=0 ; i<=end; ){

            if(arr[i] < lowVal){
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                i++;
                start++;

            }else if(arr[i] > highVal){
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;

            }else {
                i++;
            }
        }

        System.out.println(arr);
    }

    public pair[] allPairs( long A[], long B[], long N, long M, long X) {

        // Your code goes here
        List<pair> pairs = new ArrayList<>();
        List<Long> BList = new ArrayList<>();
        for(int i=0; i<M; i++){
            BList.add(B[i]);
        }

        for(int i=0 ; i<N; i++){
            if(BList.contains(X-A[i])){
                System.out.println(A[i]+" "+(X-A[i]));
                pairs.add(new pair(A[i], (X-A[i])));
            }
        }

        pair[] pairs1 = new pair[pairs.size()];
        for(int i=0; i< pairs.size(); i++){
            pairs1[i] = pairs.get(i);
        }
        return pairs1;
    }

    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr2.length; i++){
            map.put(arr2[i], 0);
        }

        for(int i=0; i<arr1.length; i++){
            if(!map.containsKey(arr1[i])){
                return i;
            }
        }

        return -1;
    }

    public static void zigZag(int n, int[] arr) {
        // code here
        boolean flag = true;

        for(int i=0; i<=n-2; i++){
            if(flag){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i+1] = temp;
                }
            }else {
                if(arr[i] < arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i+1] = temp;
                }
            }

            flag = !flag;
        }

        System.out.println(arr);
    }

    public int findElement(int arr[], int n){

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        int[] rightMin = new int[n];
        rightMin[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            if(leftMax[i-1] > arr[i]){
                leftMax[i] = leftMax[i-1];
            }else {
                leftMax[i] = arr[i];
            }
        }

        for(int i=n-2; i>=0; i--){
            if(arr[i] < rightMin[i+1]){
                rightMin[i] = arr[i];
            }else {
                rightMin[i] = rightMin[i+1];
            }
        }

        for(int i=0; i<n; i++){
            if(arr[i] >= leftMax[i] && arr[i] <= rightMin[i])
                return i;
        }

        return -1;

    }

    public void subSequences(int n, int[] arr){

        List<Integer> integerList = new ArrayList<>();
        printSequences(0,n,arr,integerList);
    }
    private void printSequences(int index, int length, int[] sourceArray, List<Integer> temporaryDatastructure){

        if(index == length){
            for(Integer integer: temporaryDatastructure){
                System.out.print(integer);
            }
            System.out.print("\n");
            return;
        }

        temporaryDatastructure.add(sourceArray[index]);
        printSequences(index+1, length, sourceArray, temporaryDatastructure);
        temporaryDatastructure.remove(Integer.valueOf(sourceArray[index]));
        printSequences(index+1, length, sourceArray, temporaryDatastructure);

    }

    public void combinationSum1(int target, int[] arr){
        List<List<Integer>> answerList = new ArrayList<>();
        findComibationSum1(0,arr,target,answerList, new ArrayList<>());
        for (List<Integer> integerList: answerList){
            integerList.forEach(System.out::print);
            System.out.println("\n");
        }
    }
    private void findComibationSum1(int index, int[] arr, int target, List<List<Integer>> answerList, List<Integer> ds){
        if(index == arr.length){
            if(target == 0){
                answerList.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[index] <= target){
            ds.add(arr[index]);
            findComibationSum1(index+1, arr, target-arr[index], answerList, ds);
            ds.remove(Integer.valueOf(arr[index]));
        }
        findComibationSum1(index+1, arr, target, answerList, ds);

    }

    public void combinationSum2(int target, int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> answerList = new ArrayList<>();
        findComibationSum2(0,arr,target,answerList, new ArrayList<>());
        for (List<Integer> integerList: answerList){
            integerList.forEach(System.out::print);
            System.out.println("\n");
        }
    }
    private void findComibationSum2(int index, int[] arr, int target, List<List<Integer>> answerList, List<Integer> ds){
        if(target == 0){
            answerList.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findComibationSum2(i+1,arr,target-arr[i],answerList,ds);
            ds.remove(ds.size()-1);
        }
    }

    public void subsetSum(int length, int[] arr){
        List<Integer> srcIntList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            srcIntList.add(arr[i]);
        }
        List<Integer> subSetList = new ArrayList<>();
        subSetSumFunc(0,length,0,srcIntList,subSetList);
        Collections.sort(subSetList);
        for(Integer sum: subSetList){
            System.out.print(sum+" ");
        }
    }
    private void subSetSumFunc(int index, int length, int sum, List<Integer> srcLst, List<Integer> subSetList){
        if(index==length){
            subSetList.add(sum);
            return;
        }

        subSetSumFunc(index+1, length,sum+srcLst.get(index),srcLst, subSetList);

        subSetSumFunc(index+1, length,sum,srcLst, subSetList);
    }

    public void findNonDuplicateSubsets(int length, int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> answerList = new ArrayList<>();
        findNonDuplicateSubsetsFunc(0,length,arr,answerList,new ArrayList<>());
        for (List<Integer> integerList: answerList){
            integerList.forEach(System.out::print);
            System.out.println("");
        }
    }
    private void findNonDuplicateSubsetsFunc(int index, int length, int[] arr, List<List<Integer>> answerList, List<Integer> ds){
        answerList.add(new ArrayList<>(ds));

        for (int i=index; i<length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;

            ds.add(arr[i]);
            findNonDuplicateSubsetsFunc(index+1,length,arr,answerList,ds);
            ds.remove(Integer.valueOf(arr[i]));
        }

    }

    public void printPermutation(int length, int[] arr){
        List<List<Integer>> answerList = new ArrayList<>();
        List<Integer> dsList = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];

        printPermutationFunc(0,length,arr,answerList,dsList,freq);
        for (List<Integer> integerList: answerList){
            integerList.forEach(System.out::print);
            System.out.println("");
        }
    }
    private void printPermutationFunc(int index, int length, int[] arr, List<List<Integer>> answerList, List<Integer> ds,boolean[] freq){
        //below portion is important as the resultant array should contain all the elements and the size should be equal to the size of array
        if(ds.size() == length){
            answerList.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                printPermutationFunc(i+1,length,arr,answerList,ds,freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

    public void printPermutationOptimum(int length, int[] arr){
        List<List<Integer>> answerList = new ArrayList<>();
        printPermutationOptimumFunc(0,length,arr,answerList);

        for (List<Integer> integerList: answerList){
            integerList.forEach(System.out::print);
            System.out.println("");
        }
    }
    private void printPermutationOptimumFunc(int index, int length, int[] arr, List<List<Integer>> answerList){
        //below portion is important as the resultant array should contain all the elements and the size should be equal to the size of array
        if(index == length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<index; i++){
                ds.add(arr[i]);
            }
            answerList.add(ds);
        }

        for(int i=index; i<length; i++){
            swap(i,index,arr);
            printPermutationOptimumFunc(index+1,length,arr,answerList);
            swap(i,index,arr);
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextGreaterElement(int n, int[] nums){
        int[] temp = new int[nums.length];
        Stack stack = new Stack();

        for(int i=(2*n-1); i>=0; i--){
            while(!stack.isEmpty() && Integer.valueOf((Integer) stack.peek()) <= nums[i%n]){
                stack.pop();
            }

            if(i<n){
                if(stack.isEmpty()){
                    temp[i] = -1;
                }else {
                    temp[i] = (int) stack.peek();
                }
            }

            stack.push(nums[i%n]);
        }

        for(int i=0; i<n; i++){
            System.out.print(temp[i]);
        }

    }

    public void largestRectangleArea(int[] heightsArray){

        int len = heightsArray.length;
        int [] rightSmallestArray = new int[len];
        int [] leftSmallestArray = new int[len];
        Stack<Integer> integerStack = new Stack<>();

        for(int i=0; i<len; i++){
            while (!integerStack.isEmpty() && heightsArray[integerStack.peek()] >= heightsArray[i]){
                integerStack.pop();
            }

            if(integerStack.isEmpty()){
                leftSmallestArray[i] = 0;
            }else {
                leftSmallestArray[i] = integerStack.peek()+1;
            }

            integerStack.push(i);
        }

        while (!integerStack.isEmpty())
            integerStack.pop();

        for(int i=len-1; i>=0; i--){
            while (!integerStack.isEmpty() && heightsArray[integerStack.peek()] >= heightsArray[i]){
                integerStack.pop();
            }

            if(integerStack.isEmpty()){
                rightSmallestArray[i] = len-1;
            }else {
                rightSmallestArray[i] = integerStack.peek()-1;
            }

            integerStack.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < len; i++) {
            maxA = Math.max(maxA, heightsArray[i] * (rightSmallestArray[i] - leftSmallestArray[i] + 1));
        }

        System.out.println(maxA);

    }

    public void largestRectangleAreaOptimum(int[] heightsArray){

        int len = heightsArray.length;
        Stack<Integer> integerStack = new Stack<>();
        int maxA = 0;

        for(int i=0; i<=len; i++){

            while (!integerStack.isEmpty() && (i == len || heightsArray[integerStack.peek()] >= heightsArray[i])){
                int height = heightsArray[integerStack.peek()];
                integerStack.pop();
                int width;
                if(integerStack.isEmpty()){
                    width = i;
                }else {
                    width = i-integerStack.peek()-1;
                }
                maxA = Math.max(maxA, width * height);
            }

            integerStack.push(i);
        }

        System.out.println(maxA);

    }

    public void maxInSubArrays(int k, int[] arr){

        int len = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] r = new int[len-k+1];
        int ri = 0;

        for(int i=0; i<len; i++){

            //shorten unwanted size
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }

            //remove the smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }

            dq.offer(i);
            if(i >= k-1){
                r[ri++] = arr[dq.peek()];
            }

        }

        System.out.println(r);

        //return r
        //output: [3, 3, 5, 5, 6, 7]

    }

}

