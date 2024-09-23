package J8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        List<String> uniqueElements = listOfStrings.stream().distinct().collect(Collectors.toList());

        System.out.println(uniqueElements);

        listOfStrings.stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("--------- Duplicate Elements ---------------");
        Set<String> stringSet = new HashSet<>();
        listOfStrings.stream().filter(val -> !stringSet.add(val)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
