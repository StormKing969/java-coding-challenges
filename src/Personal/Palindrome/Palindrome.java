package Personal.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        // Example input string
        String[] stringList = {"bb"};

        for (String s : stringList) {
            // Check if the input string is a palindrome
//            boolean result = isPalindrome(s);
//            System.out.println("Is palindrome: " + result);

            // Find all palindromic substrings
            System.out.println("Palindromic substrings: " + palindromicSubstrings(s));
            System.out.println("Longest Palindrome: " + longestPalindrome(s));
        }
    }

    /**
     * Checks if a given string is a palindrome.
     * @param s input string
     * @return true if s is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        List<String> result = new ArrayList<>();
        int wordLength = s.length();

        for (int i = 0; i < wordLength; i++) {
            for (int j = i + 1; j < wordLength; j++) {
                System.out.println(s.substring(i, j + 1));
                if (isPalindrome(s.substring(i, j + 1))) {
                    result.add(s.substring(i, j + 1));
                }
            }
        }

        System.out.println(result);

        String word = String.valueOf(s.charAt(0));
        int longest = 1;
        for (String ele : result) {
            if (ele.length() > longest) {
                word = ele;
                longest= ele.length();
            }
        }

        return word;
    }

    /**
     * Finds all palindromic substrings by checking substrings from both ends.
     * @param s input string
     * @return list of palindromic substrings
     */
    public static List<String> palindromicSubstrings(String s) {
        List<String> result = new ArrayList<>();
        int wordLength = s.length();

        for (int i = 0; i <= wordLength / 2; i++) {
            String substring = s.substring(i, wordLength - i);
            if (!substring.isEmpty() && isPalindrome(substring)) {
                result.add(substring);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            String substring = s.substring(i, wordLength);
            if (isPalindrome(substring)) {
                if (!result.contains(substring)) {
                    result.add(substring);
                }
            }
        }

        return result;
    }
}