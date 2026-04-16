package NeetCode.Valid_Palindrome;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome("tab a cat"));
    }

    public static boolean isPalindrome(String s) {
        char[] letter = s.toLowerCase().toCharArray();
        List<Character> sentence = new ArrayList<>();
        for (Character ele : letter) {
            if (!Character.isLetterOrDigit(ele)) {
                continue;
            }

            sentence.add(ele);
        }

        int left = 0;
        int right = sentence.size() - 1;
        while (left < right) {
            if (sentence.get(left) != sentence.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
