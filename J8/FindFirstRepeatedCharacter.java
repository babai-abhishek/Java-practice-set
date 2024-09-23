package J8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedCharacter {

    public static void main(String[] args) {

        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

        String str = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().get();

        System.out.println(str);
    }
}
