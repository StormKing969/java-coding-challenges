package LeetCode.Longest_Common_Prefix;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr1 = {"flower", "flow", "flight"};
        System.out.println(Arrays.toString(arr1) + " => fl = " + longestCommonPrefix(arr1));

        String[] arr2 = {"dog","racecar","car"};
        System.out.println(Arrays.toString(arr2) + " => '' = " + longestCommonPrefix(arr2));
    }

    public static String longestCommonPrefix(String[] words) {
        StringBuilder prefix = new StringBuilder();
        if (words == null || words.length == 0) {
            return "";
        }

        int wordSize = words[0].length();
        for (String word : words) {
            if (word.length() < wordSize) {
                wordSize = word.length();
            }
        }

        int currentIndex = 0;
        boolean sameLetter = true;
        while (currentIndex < wordSize) {
            char currentChar = words[0].charAt(currentIndex);
            for (String word : words) {
                if (word.charAt(currentIndex) != currentChar) {
                    sameLetter = false;
                    break;
                }
            }

            if (!sameLetter) {
                break;
            }

            prefix.append(currentChar);
            currentIndex++;
        }

        return prefix.toString();
    }
}
