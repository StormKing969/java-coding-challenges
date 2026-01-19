package LeetCode.Reverse_Words_In_A_String;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("blue is sky the => " + reverseWords("the sky is blue"));
        System.out.println("world hello => " + reverseWords("  hello world  "));
        System.out.println("example good a => " + reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        words = Arrays.stream(words).filter(w -> !w.isEmpty()).toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
