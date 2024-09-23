package J8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrom {

    public static void main(String[] args) {
        String str = "ROTATOR";

        String str2 = IntStream.rangeClosed(1,str.length())
                .mapToObj(s -> str.charAt(str.length()-s))
                .map(String::valueOf)
                .collect(
                        Collectors.joining()
                );

        if(str.equals(str2)){
            System.out.println("Palindrom");
        }else {
            System.out.println("Not Palindrom");
        }

        boolean isItPalindrome = IntStream.range(0, str.length()/2).
                noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i -1));

        if (isItPalindrome)
        {
            System.out.println(str+" is a palindrome");
        }
        else
        {
            System.out.println(str+" is not a palindrome");
        }

        char[] arr = {'h', 'e', 'l', 'l', 'o'};

       /* IntStream.range(0, arr.length / 2)
                .forEach(i -> {
                    // Calculate the index of the element from the end
                    int oppositeIndex = arr.length - 1 - i;

                    // Swap the characters
                    char temp = arr[i];
                    arr[i] = arr[oppositeIndex];
                    arr[oppositeIndex] = temp;
                });*/

        Object[] result = IntStream.range(0, arr.length)
                .mapToObj(s -> arr[arr.length-s-1])
                .toArray();

        Arrays.stream(result).forEach(System.out::println);
    }
}
