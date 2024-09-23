package J8;

import java.util.Arrays;
import java.util.List;

public class StartsWithNumber {

    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        listOfStrings.stream().map(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);

        listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);

        //TODO number/String starts with 1
        System.out.println("---------- starts with 1 ---------------");
        int[] arr = new int[]{11,22,33,12,15,1};
        Arrays.stream(arr)
                .mapToObj(num -> num+"")
                .filter(val -> Character.isDigit(val.charAt(0)) && val.charAt(0) == '1')
                .forEach(System.out::println);

    }
}
