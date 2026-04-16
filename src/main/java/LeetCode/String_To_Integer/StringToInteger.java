package LeetCode.String_To_Integer;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("42 => 42 = " + myAtoi("42"));
        System.out.println(" -042 => -42 = " + myAtoi(" -042"));
        System.out.println("1337c0d3 => 1337 = " + myAtoi("1337c0d3"));
        System.out.println("0-1 => 0 = " + myAtoi("0-1"));
        System.out.println("words and 987 => 0 = " + myAtoi("words and 987"));
        System.out.println("+-12 => 0 = " + myAtoi("+-12"));

        System.out.println("42 => 42 = " + myAtoiV2("42"));
        System.out.println(" -042 => -42 = " + myAtoiV2(" -042"));
        System.out.println("1337c0d3 => 1337 = " + myAtoiV2("1337c0d3"));
        System.out.println("0-1 => 0 = " + myAtoiV2("0-1"));
        System.out.println("words and 987 => 0 = " + myAtoiV2("words and 987"));
        System.out.println("+-12 => 0 = " + myAtoiV2("+-12"));
        System.out.println("+-12 => 0 = " + myAtoiV2(" "));
    }

    public static int myAtoi(String s) {
        int ans;
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        List<Character> acceptedCharacters = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.isEmpty()) {
                if ((c == '+' || c == '-')) {
                    if (i + 1 < s.length() && acceptedCharacters.contains(s.charAt(i + 1))) {
                        if (c == '-') {
                            negative = true;
                        }

                        continue;
                    } else {
                        return 0;
                    }
                }

                if (c == ' ') {
                    continue;
                }
            }

            if (acceptedCharacters.contains(c)) {
                sb.append(c);
            } else {
                break;
            }
        }

        try {
            if (sb.isEmpty()) {
                ans = 0;
            } else {
                ans = Integer.parseInt(sb.toString());
            }
        } catch (NumberFormatException e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return negative ? -ans : ans;
    }

    public static int myAtoiV2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        boolean negative = false;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            if (s.charAt(index) == '-') {
                negative = true;
            }
            index++;
        }

        int answer = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (answer > (Integer.MAX_VALUE - digit) / 10) { return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE; }

            answer = answer * 10 + digit;
            index++;
        }

        return negative ? -answer : answer;
    }
}
