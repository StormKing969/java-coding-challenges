package NeetCode.Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Hint: think about what data structure naturally handles
    // "process later once I have both operands".
    //
    // When you see a number  → store it somewhere
    // When you see an operator → grab the last two numbers and apply it

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        if (tokens.length == 3) return calculateValue(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);

        Deque<Integer> values = new ArrayDeque<>();
        values.push(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = values.pop();
                int a = values.pop();
                int currentEval = calculateValue(a, b, tokens[i]);
                values.push(currentEval);
            } else {
                values.push(Integer.parseInt(tokens[i]));
            }
        }

        return values.pop();
    }

    private int calculateValue(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> 0;
        };

    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
        int passed = 0, failed = 0;

        // ── Test 1: example from the problem ──────────────────────────────────
        {
            int r = check("Test 1  – ((1+2)*3)-4 = 5",
                    sol.evalRPN(new String[]{"1","2","+","3","*","4","-"}), 5);
            failed += r; passed += 1 - r;
        }

        // ── Test 2: single number ─────────────────────────────────────────────
        {
            int r = check("Test 2  – single token \"42\"",
                    sol.evalRPN(new String[]{"42"}), 42);
            failed += r; passed += 1 - r;
        }

        // ── Test 3: simple addition ───────────────────────────────────────────
        {
            int r = check("Test 3  – 2 + 3 = 5",
                    sol.evalRPN(new String[]{"2","3","+"}), 5);
            failed += r; passed += 1 - r;
        }

        // ── Test 4: simple subtraction ────────────────────────────────────────
        {
            int r = check("Test 4  – 10 - 4 = 6",
                    sol.evalRPN(new String[]{"10","4","-"}), 6);
            failed += r; passed += 1 - r;
        }

        // ── Test 5: simple multiplication ────────────────────────────────────
        {
            int r = check("Test 5  – 3 * 7 = 21",
                    sol.evalRPN(new String[]{"3","7","*"}), 21);
            failed += r; passed += 1 - r;
        }

        // ── Test 6: division truncates toward zero (positive) ─────────────────
        {
            int r = check("Test 6  – 7 / 2 = 3  (truncate toward zero)",
                    sol.evalRPN(new String[]{"7","2","/"}), 3);
            failed += r; passed += 1 - r;
        }

        // ── Test 7: division truncates toward zero (negative) ─────────────────
        {
            // -7 / 2 should be -3, not -4
            int r = check("Test 7  – -7 / 2 = -3 (truncate toward zero, not floor)",
                    sol.evalRPN(new String[]{"-7","2","/"}), -3);
            failed += r; passed += 1 - r;
        }

        // ── Test 8: negative operands ─────────────────────────────────────────
        {
            // 4 + (-3) = 1
            int r = check("Test 8  – 4 + (-3) = 1",
                    sol.evalRPN(new String[]{"4","-3","+"}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 9: operand order matters for subtraction ─────────────────────
        {
            // 5 3 - = 5 - 3 = 2  (not 3 - 5)
            int r = check("Test 9  – operand order: 5 3 - = 2 (not -2)",
                    sol.evalRPN(new String[]{"5","3","-"}), 2);
            failed += r; passed += 1 - r;
        }

        // ── Test 10: longer nested expression ────────────────────────────────
        {
            // ["2","1","+","3","*"] → (2+1)*3 = 9
            int r = check("Test 10 – (2+1)*3 = 9",
                    sol.evalRPN(new String[]{"2","1","+","3","*"}), 9);
            failed += r; passed += 1 - r;
        }

        // ── Test 11: result of division used in further ops ───────────────────
        {
            // ["6","2","/","5","+"] → (6/2)+5 = 8
            int r = check("Test 11 – (6/2)+5 = 8",
                    sol.evalRPN(new String[]{"6","2","/","5","+"}), 8);
            failed += r; passed += 1 - r;
        }

        // ── Test 12: result of ops at the end of list ───────────────────
        {
            // ["4","13","5","/","+"]→ (13/5)+4 = 6
            int r = check("Test 11 – (13/5)+4 = 6",
                    sol.evalRPN(new String[]{"4","13","5","/","+"}), 6);
            failed += r; passed += 1 - r;
        }

        System.out.println("\n──────────────────────────────");
        System.out.printf("  Results: %d passed, %d failed%n", passed, failed);
        System.out.println("──────────────────────────────");
    }

    private static int check(String name, int actual, int expected) {
        if (actual == expected) {
            System.out.printf("  ✓ %s%n", name);
            return 0;
        } else {
            System.out.printf("  ✗ %s  →  expected %d, got %d%n", name, expected, actual);
            return 1;
        }
    }
}
