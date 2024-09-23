package J8;

import java.util.Arrays;
import java.util.List;

public class MultipliedBy {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().filter(val -> val % 5 == 0).forEach(System.out::println);
    }
}
