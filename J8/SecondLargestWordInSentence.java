package J8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class SecondLargestWordInSentence {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";

        String secondLargestWord = Stream.of(sentence.split(" "))
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed()).skip(1)
                .findFirst()
                .get();

        System.out.println(secondLargestWord);

        HashMap<String, Integer> lengthMap = new HashMap<>();
        Stream.of(sentence.split(" ")).distinct().forEach(val -> lengthMap.put(val,val.length()));
        String secondLargestWord2 =  lengthMap.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder())).skip(1)
                .findFirst().get().getKey();
        System.out.println(secondLargestWord2);
    }
}
