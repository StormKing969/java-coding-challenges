package LeetCode.Longest_Palindromic_Substring;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println("babad => bab = " + longestPalindrome("babad"));
        System.out.println("cbbd => bb = " + longestPalindrome("cbbd"));
        System.out.println("a => a = " + longestPalindrome("a"));
        System.out.println("cd => c = " + longestPalindrome("cd"));
    }

    public static String longestPalindrome(String s) {
        int left = 0;
        int maxLen = 0;
        String answer = "";
        if (s == null || s.isEmpty()) {
            return answer;
        }

        if (s.length() == 1) {
            return s;
        }

        while (left < s.length()) {
            int right = s.length() - 1;
            while (right >= left) {
                String word = s.substring(left, right + 1);
                if (word.length() > maxLen && isPalindrome(word)) {
                    maxLen = word.length();
                    answer = word;
                }
                right--;
            }
            left++;
        }

        return answer;
    }

    private static boolean isPalindrome(String s) {
        int  left = 0;
        int right = s.length() - 1;
        if (s.length() == 1) {
            return true;
        }

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
