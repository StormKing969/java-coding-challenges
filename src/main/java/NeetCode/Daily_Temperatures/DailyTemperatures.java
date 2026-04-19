package NeetCode.Daily_Temperatures;

import java.util.Arrays;

public class DailyTemperatures {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Hint: a brute-force O(n²) nested loop works within the constraints,
    // but there is an O(n) solution using a stack.
    //
    // For the O(n) approach, think about storing *indices* (not temperatures)
    // in the stack. As you scan forward, ask yourself:
    //   "Does today's temperature resolve any previous unanswered days?"

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) return new int[]{};

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > currentTemp) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        int passed = 0, failed = 0;

        // ── Test 1: example 1 from the problem ────────────────────────────────
        {
            int r = check("Test 1  – [30,38,30,36,35,40,28] → [1,4,1,2,1,0,0]",
                    sol.dailyTemperatures(new int[]{30,38,30,36,35,40,28}),
                    new int[]{1,4,1,2,1,0,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 2: example 2 — all descending, no warmer day ever ────────────
        {
            int r = check("Test 2  – [22,21,20] → [0,0,0]",
                    sol.dailyTemperatures(new int[]{22,21,20}),
                    new int[]{0,0,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 3: single element ────────────────────────────────────────────
        {
            int r = check("Test 3  – [55] → [0]",
                    sol.dailyTemperatures(new int[]{55}),
                    new int[]{0});
            failed += r; passed += 1 - r;
        }

        // ── Test 4: all ascending — answer is always 1 ────────────────────────
        {
            int r = check("Test 4  – [10,20,30,40] → [1,1,1,0]",
                    sol.dailyTemperatures(new int[]{10,20,30,40}),
                    new int[]{1,1,1,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 5: all same temperature ─────────────────────────────────────
        {
            int r = check("Test 5  – [50,50,50] → [0,0,0]  (equal is not warmer)",
                    sol.dailyTemperatures(new int[]{50,50,50}),
                    new int[]{0,0,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 6: warmer day is many steps away ─────────────────────────────
        {
            // only the last element is warmer than everything before it
            int r = check("Test 6  – [10,10,10,50] → [3,2,1,0]",
                    sol.dailyTemperatures(new int[]{10,10,10,50}),
                    new int[]{3,2,1,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 7: two elements, first is colder ─────────────────────────────
        {
            int r = check("Test 7  – [30,40] → [1,0]",
                    sol.dailyTemperatures(new int[]{30,40}),
                    new int[]{1,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 8: two elements, first is warmer ─────────────────────────────
        {
            int r = check("Test 8  – [40,30] → [0,0]",
                    sol.dailyTemperatures(new int[]{40,30}),
                    new int[]{0,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 9: spike in the middle ───────────────────────────────────────
        {
            // [20,30,100,30,20] — everything resolves at index 2
            int r = check("Test 9  – [20,30,100,30,20] → [1,1,0,0,0]",
                    sol.dailyTemperatures(new int[]{20,30,100,30,20}),
                    new int[]{1,1,0,0,0});
            failed += r; passed += 1 - r;
        }

        // ── Test 10: valley then rise ─────────────────────────────────────────
        {
            // [70,60,50,80] — the 80 resolves all three prior days at once
            int r = check("Test 10 – [70,60,50,80] → [3,2,1,0]",
                    sol.dailyTemperatures(new int[]{70,60,50,80}),
                    new int[]{3,2,1,0});
            failed += r; passed += 1 - r;
        }

        System.out.println("\n──────────────────────────────");
        System.out.printf("  Results: %d passed, %d failed%n", passed, failed);
        System.out.println("──────────────────────────────");
    }

    private static int check(String name, int[] actual, int[] expected) {
        if (Arrays.equals(actual, expected)) {
            System.out.printf("  ✓ %s%n", name);
            return 0;
        } else {
            System.out.printf("  ✗ %s%n    expected %s%n    got      %s%n",
                    name, Arrays.toString(expected), Arrays.toString(actual));
            return 1;
        }
    }
}
