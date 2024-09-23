package J8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OddEvenWithoutTwoFilter {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        Map<Boolean,List<Integer>> map = nums.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        for (Map.Entry entry: map.entrySet()){
            if(entry.getKey().toString().equals("true")){
                System.out.println("Even numbers : ");
                System.out.println(entry.getValue());
            }else {
                System.out.println("Odd numbers : ");
                System.out.println(entry.getValue());
            }
        }

    }
}
