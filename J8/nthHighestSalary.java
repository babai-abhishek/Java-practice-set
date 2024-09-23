package J8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class nthHighestSalary {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("anil",1000);
        map.put("ankit",1200);
        map.put("bhavna",1300);
        map.put("james",1400);
        map.put("micael",1500);
        map.put("tom",1600);
        map.put("daniel",1700);

        Map.Entry<String,Integer> secondHighestSalary = map.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(en -> en.getValue()))
                .skip(map.size()-2)
                .findFirst()
                .get();

        System.out.println(secondHighestSalary.getKey()+" "+secondHighestSalary.getValue());

        Map.Entry<String,Integer> highestSalary = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> -entry.getValue())) // minus make it to do in desc order
                .toList()
                .get(0);

        System.out.println(highestSalary.getKey()+" "+highestSalary.getValue());

        Map.Entry<Integer, List<String>> secondLowestSalary = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry ->entry.getValue(),
                        Collectors.mapping(entry -> entry.getKey(),Collectors.toList())
                ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(it -> it.getKey()))
                .toList()
                .get(1);

        System.out.println(secondLowestSalary.getKey()+" "+secondLowestSalary.getValue());

    }
}
