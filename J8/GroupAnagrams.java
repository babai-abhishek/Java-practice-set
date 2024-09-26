package J8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // Function to group anagrams
    public static List<List<String>> groupAnagrams(String[] words) {
        // Using a map to group words by their sorted character sequence
        Map<String, List<String>> anagramMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> {
                    // Sort the characters of each word to form the key
                    char[] charArray = word.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }));

        // Return the values as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(words);

        // Print the grouped anagrams
        groupedAnagrams.forEach(System.out::println);
    }
}
