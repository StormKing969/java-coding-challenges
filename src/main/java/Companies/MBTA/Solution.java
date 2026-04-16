package Companies.MBTA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Question 01
        // Write a function that takes in a String and returns a count for each letter.
        // For example: "Hello" --> {"H":1, "e":1, "l": 2, "o": 1}
        System.out.println(getLetterCount("HelloWorld"));

        // Question 02
        // Write a function that takes in a string sentence and returns a new sentence where the words are rearranged by
        // their length.
        // For example: “hello friendly cat” --> “cat hello friendly”
        System.out.println(rearrangeSentence("hello my beautiful friendly white cat"));

        // Question 03
        // As in the previous problem, write a function that takes in a string sentence and returns a new sentence where
        // the words are rearranged by their length, but this time, each word should preserve the capitalization of the
        // word that was in its place in the original sentence.
        // For example: “Hello cat” --> “Cat hello”
        System.out.println("Hello my Beautiful Friendly white cat");
        System.out.println(caseSensitiveSentence("Hello my Beautiful Friendly white cat"));

    }

    public static Map<Character, Integer> getLetterCount(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        return map;
    }

    public static String rearrangeSentence(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        words.sort(Comparator.comparingInt(String::length));
        return String.join(" ", words);
    }

    public static String caseSensitiveSentence(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        List<Integer> toChange = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (Character.isUpperCase(words.get(i).charAt(0))) {
                toChange.add(i);
                words.set(i, words.get(i).toLowerCase());
            }
        }

        words.sort(Comparator.comparingInt(String::length));
        for (int index : toChange) {
            words.set(index, words.get(index).toUpperCase());
        }

        return String.valueOf(words);
    }
}
