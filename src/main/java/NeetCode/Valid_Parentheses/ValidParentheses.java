package NeetCode.Valid_Parentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("[]"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("[(])"));
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1) return false;

        Stack<String> stack = new Stack<>();
        for (String ele : s.split("")) {
            if (ele.equals("(") || ele.equals("{") || ele.equals("[")) {
                stack.push(ele);
            } else {
                if (stack.isEmpty()) return false;

                if (ele.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else if (ele.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else if (ele.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
