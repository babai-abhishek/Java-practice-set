package J8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OddEven {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        Map<Boolean, List<Integer>> booleanListMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));

        Set<Map.Entry<Boolean, List<Integer>>> entrySet = booleanListMap.entrySet();

        for(Map.Entry<Boolean, List<Integer>> entry: entrySet){

            if(entry.getKey()){
                System.out.println("Even numbers -->");
            }else {
                System.out.println("Odd numbers -->");
            }

            for(Integer value: entry.getValue()){
                System.out.println(value);
            }
        }

        Map<Boolean, List<Integer>> booleanListMap1 = listOfIntegers.stream().collect(Collectors.groupingBy(i -> i%2 == 0));

        Set<Map.Entry<Boolean, List<Integer>>> entrySet1 = booleanListMap1.entrySet();

        for(Map.Entry<Boolean, List<Integer>> entry: entrySet1){

            if(entry.getKey()){
                System.out.println("Even numbers -->");
            }else {
                System.out.println("Odd numbers -->");
            }

            for(Integer value: entry.getValue()){
                System.out.println(value);
            }
        }
    }
}
