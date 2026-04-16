package LeetCode.Reverse_Vowels_Of_A_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println("AceCreIm => " + reverseVowels("IceCreAm"));
        System.out.println("leotcede => " + reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                Character c = stack.pop();
                sb.append(c);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
