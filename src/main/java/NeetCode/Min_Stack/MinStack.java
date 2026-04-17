package NeetCode.Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Hint: a single stack isn't enough to track the minimum in O(1).
    // Think about what extra information you could store alongside each value.
    private final Deque<Integer> stack;

    /** Initializes the stack object. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    /** Pushes val onto the stack. */
    public void push(int val) {
        stack.push(val);
    }

    /** Removes the top element. */
    public void pop() {
        stack.pop();
    }

    /** Returns the top element. */
    public int top() {
        if (!stack.isEmpty()) return stack.peek();

        return -1;
    }

    /** Returns the minimum element in the stack in O(1). */
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int ele : stack) {
            if (ele < min) {
                min = ele;
            }
        }

        return min;
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        // ── Test 1: example from the problem ──────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(1);
            s.push(2);
            s.push(0);
            failed += check("Test 1a – getMin after push 1,2,0", s.getMin(), 0);
            s.pop();
            failed += check("Test 1b – top after pop",           s.top(),    2);
            failed += check("Test 1c – getMin after pop",        s.getMin(), 1);
            passed += 3 - failed;   // rough tally; reset per group below
        }

        // reset counters properly
        passed = 0; failed = 0;

        // ── Test 2: single element ─────────────────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(42);
            int r1 = check("Test 2a – top of single element",  s.top(),    42);
            int r2 = check("Test 2b – min of single element",  s.getMin(), 42);
            failed += r1 + r2;
            passed += 2 - r1 - r2;
        }

        // ── Test 3: push in ascending order ───────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(1); s.push(2); s.push(3);
            int r = check("Test 3  – min stays at 1 when pushing larger values",
                    s.getMin(), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 4: push in descending order ──────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(3); s.push(2); s.push(1);
            int r = check("Test 4  – min is 1 when pushing descending",
                    s.getMin(), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 5: min is restored after popping the current min ─────────────
        {
            MinStack s = new MinStack();
            s.push(5); s.push(3); s.push(7); s.push(1);
            int r1 = check("Test 5a – min is 1",      s.getMin(), 1);
            s.pop();   // removes 1
            int r2 = check("Test 5b – min restored to 3", s.getMin(), 3);
            failed += r1 + r2; passed += 2 - r1 - r2;
        }

        // ── Test 6: duplicate minimums ────────────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(2); s.push(1); s.push(1);
            int r1 = check("Test 6a – min is 1 (duplicates)",  s.getMin(), 1);
            s.pop();
            int r2 = check("Test 6b – min still 1 after pop",  s.getMin(), 1);
            s.pop();
            int r3 = check("Test 6c – min back to 2",          s.getMin(), 2);
            failed += r1 + r2 + r3; passed += 3 - r1 - r2 - r3;
        }

        // ── Test 7: negative numbers ───────────────────────────────────────────
        {
            MinStack s = new MinStack();
            s.push(-3); s.push(0); s.push(-5);
            int r1 = check("Test 7a – min handles negatives",   s.getMin(), -5);
            s.pop();
            int r2 = check("Test 7b – min after popping -5",    s.getMin(), -3);
            failed += r1 + r2; passed += 2 - r1 - r2;
        }

        System.out.println("\n──────────────────────────────");
        System.out.printf("  Results: %d passed, %d failed%n", passed, failed);
        System.out.println("──────────────────────────────");
    }

    // Returns 0 if the test passed, 1 if it failed.
    private static int check(String name, int actual, int expected) {
        if (actual == expected) {
            System.out.printf("  ✓ %s%n", name);
            return 0;
        } else {
            System.out.printf("  ✗ %s  →  expected %d, got %d%n",
                    name, expected, actual);
            return 1;
        }
    }
}