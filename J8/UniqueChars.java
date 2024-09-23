package J8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueChars {

    public static void main(String[] args) {
        String inputString = "Java Concept Of The Day";

        String[] result = Stream.of(inputString
                        .replaceAll("\\s+", "")
                        .toLowerCase()
                        .split(""))
                .collect(Collectors
                        .groupingBy(Function
                                .identity(),Collectors
                                .counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(val -> val.getKey()).toArray(String[]::new);

        System.out.println(Arrays.toString(result));

        Set<String> uniqueChars = new HashSet<>();

        Set<String> duplicateChars =
                Arrays.stream(inputString
                                .replaceAll("\\s+", "")
                                .toLowerCase().split(""))
                        .filter(ch -> ! uniqueChars.add(ch))
                        .collect(Collectors.toSet());

        System.out.println(duplicateChars);

    }
}
