package LeetCode.Is_Subsequence;

import java.util.Stack;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("cbc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("b", "abc"));

        System.out.println(isSubsequenceV2("cb", "ahbgdc"));
        System.out.println(isSubsequenceV2("axc", "ahbgdc"));
        System.out.println(isSubsequenceV2("b", "abc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSubsequenceV2(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        int index = 0;
        if (s.length() != 1) {
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(index)) {
                    index++;
                }

                if (index > s.length() - 1) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(index)) {
                    return true;
                }
            }
        }

        return false;
    }
}
