package J8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class SortMapByValue {

    public static void main(String[] args) {
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

//        budget.entrySet().stream().map(entry -> entry.getValue()).sorted().forEach(System.out::println);

        //TODO use of toMap() and comparingByValue()
        Map<String, Integer> sorted = budget.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect( toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new
                ));

        System.out.println(sorted);

        Map<String, Integer> sortedInReverse = budget .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect( toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new));

        System.out.println(sortedInReverse);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream()
                .map(str -> str+"").filter(val -> val.startsWith("1")).collect(Collectors.toList()).forEach(System.out::println);

        int max =  myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        System.out.println("Max value "+myList.stream().sorted(Comparator.reverseOrder()).findFirst().get());

        String input = "Java articles are Awesome";
        input.replaceAll("\\s+","").toLowerCase()
                .chars()
                .mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().ifPresent(System.out::println);

        myList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
