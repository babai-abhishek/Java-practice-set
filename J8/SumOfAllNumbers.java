package J8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfAllNumbers {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);

        int sum = integerList.stream().mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of elements : "+sum);

        int sum1 = integerList.stream().collect(Collectors
                .summingInt(Integer::intValue));
        System.out.println("Sum of elements : "+sum1);

    }
}
