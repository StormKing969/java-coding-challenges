package LeetCode.Removing_Stars_From_A_String;

import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            }

            if (c != '*') {
                stack.push(c);
            }
        }

        char[] arr = new char[stack.size()];
        int i = arr.length - 1;
        while (!stack.isEmpty()) {
            arr[i--] = stack.pop();
        }

        return new String(arr);
    }

    public static String removeStarsV2(String s) {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }

        return c.toString();
    }
}
