package LeetCode.Palindrome_Number;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("121 => " + isPalindrome(121));
        System.out.println("-121 => " + isPalindrome(-121));
        System.out.println("10 => " + isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
