package LeetCode.Letter_Combinations_Of_A_Phone_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println("['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf'] => " + letterCombinations("23"));
        System.out.println("['a', 'b', 'c'] => " + letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, List<String>> map = Map.of(
                "2", List.of("a", "b", "c"),
                "3", List.of("d", "e", "f"),
                "4", List.of("g", "h", "i"),
                "5", List.of("j", "k", "l"),
                "6", List.of("m", "n", "o"),
                "7", List.of("p", "q", "r", "s"),
                "8", List.of("t", "u", "v"),
                "9", List.of("w", "x", "y", "z"));

        List<String> letters = new ArrayList<>();
        if (digits.isEmpty()) return letters;
        if (digits.length() == 1) {
            return map.getOrDefault(digits, new ArrayList<>());
        }

        combinations(digits, letters, map, new StringBuilder(), 0);

        return letters;
    }

    private static void combinations(String digits, List<String> combinations,  Map<String, List<String>> map, StringBuilder sb, int index) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        for (String letter : map.get(digits.substring(index, index + 1))) {
            sb.append(letter);
            combinations(digits, combinations, map, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
