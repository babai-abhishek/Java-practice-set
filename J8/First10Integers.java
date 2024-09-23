package J8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class First10Integers {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(IntStream.rangeClosed(1,10).map(number -> number * 2).toArray()));

    }
}
