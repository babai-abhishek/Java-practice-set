package J8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class SortingBasedOnLength {

    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        System.out.println("\nIn Reverse:-\n");

        listOfStrings.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

        //TODO find the largest string in the array

        String largestString = listOfStrings.stream()
                .reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println("Largest string "+largestString);

        String largestString_2 = listOfStrings.stream()
                .reduce(BinaryOperator.maxBy(
                        Comparator.comparingInt(String::length)
                )).get();
        System.out.println("Largest string "+largestString_2);
    }
}
