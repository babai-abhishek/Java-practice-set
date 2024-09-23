package J8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxValueInArray {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        System.out.println(myList.stream().sorted(Comparator.reverseOrder()).findFirst().get());

        System.out.println(myList.stream().max(Integer::compareTo).get());
    }
}
