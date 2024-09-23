package J8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagram {

    public static void main(String[] args) {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        Map<Character, Long> map1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Character, Long> map2 = s2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map1.equals(map2) ? "Anagram" : "Not Anagram");

        Stream.of(s2.chars()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        s2.split("");

        String str1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String str2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        System.out.println(str1.equals(str2) ? "Anagram" : "Not Anagram");


    }
}
