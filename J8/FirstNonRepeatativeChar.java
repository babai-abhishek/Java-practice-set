package J8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatativeChar {

    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";

         char ch = input.replaceAll("\\s+", "").toLowerCase()
                .chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(val -> val.getValue() == 1).map(Map.Entry::getKey).findFirst().get();

        System.out.println(ch);
    }
}
