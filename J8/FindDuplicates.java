package J8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        System.out.println(Arrays.toString(listOfIntegers.stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        Function.identity(),
                                        Collectors.counting())
                ).entrySet().stream().filter(entry -> entry.getValue() > 1).map(val -> val.getKey()).toArray()));

        Set<Integer> uniqueElements = new HashSet<>();

        Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());

        System.out.println(duplicateElements);
    }
}


