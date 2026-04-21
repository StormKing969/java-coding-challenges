package NeetCode.Three_Sum;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Brute force O(n³): try every combination of three indices.
    // Works within constraints but won't teach you the better pattern.
    //
    // Optimal O(n²) — sort + two pointers:
    //
    //   1. Sort the array.
    //   2. Fix one element nums[i] in a for-loop.
    //   3. Use two pointers (left = i+1, right = n-1) to find pairs
    //      that sum to -nums[i].
    //      - sum too small → move left pointer right
    //      - sum too large → move right pointer left
    //      - exact match  → record triplet, then advance BOTH pointers
    //
    // Duplicate handling (the tricky part):
    //   - Skip nums[i] if it equals nums[i-1]  (same fixed element again)
    //   - After recording a match, skip duplicate values at left and right
    //     before continuing the two-pointer scan.

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) return new ArrayList<>();

        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicate i

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    returnList.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;   // skip duplicate left
                    while (left < right && nums[right] == nums[right - 1]) right--; // skip duplicate right
                    left++;
                    right--;
                }
            }
        }

        return returnList;
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int passed = 0, failed = 0;

        // ── Test 1: example 1 ─────────────────────────────────────────────────
        {
            int r = check("Test 1  – [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]",
                    sol.threeSum(new int[]{-1,0,1,2,-1,-4}),
                    List.of(List.of(-1,-1,2), List.of(-1,0,1)));
            failed += r; passed += 1 - r;
        }

        // ── Test 2: example 2 — no valid triplet ──────────────────────────────
        {
            int r = check("Test 2  – [0,1,1] → []",
                    sol.threeSum(new int[]{0,1,1}),
                    List.of());
            failed += r; passed += 1 - r;
        }

        // ── Test 3: example 3 — all zeros ─────────────────────────────────────
        {
            int r = check("Test 3  – [0,0,0] → [[0,0,0]]",
                    sol.threeSum(new int[]{0,0,0}),
                    List.of(List.of(0,0,0)));
            failed += r; passed += 1 - r;
        }

        // ── Test 4: all positives — no solution ───────────────────────────────
        {
            int r = check("Test 4  – [1,2,3] → []  (all positive, no zero sum)",
                    sol.threeSum(new int[]{1,2,3}),
                    List.of());
            failed += r; passed += 1 - r;
        }

        // ── Test 5: all negatives — no solution ───────────────────────────────
        {
            int r = check("Test 5  – [-3,-2,-1] → []  (all negative)",
                    sol.threeSum(new int[]{-3,-2,-1}),
                    List.of());
            failed += r; passed += 1 - r;
        }

        // ── Test 6: exactly one triplet ───────────────────────────────────────
        {
            int r = check("Test 6  – [-3,1,2] → [[-3,1,2]]",
                    sol.threeSum(new int[]{-3,1,2}),
                    List.of(List.of(-3,1,2)));
            failed += r; passed += 1 - r;
        }

        // ── Test 7: multiple duplicates, only one valid triplet ───────────────
        {
            // many zeros but only [0,0,0] is valid
            int r = check("Test 7  – [0,0,0,0] → [[0,0,0]]  (no duplicate triplets)",
                    sol.threeSum(new int[]{0,0,0,0}),
                    List.of(List.of(0,0,0)));
            failed += r; passed += 1 - r;
        }

        // ── Test 8: duplicates in input produce multiple distinct triplets ─────
        {
            // [-2,0,0,2,2] → [-2,0,2] only
            int r = check("Test 8  – [-2,0,0,2,2] → [[-2,0,2]]",
                    sol.threeSum(new int[]{-2,0,0,2,2}),
                    List.of(List.of(-2,0,2)));
            failed += r; passed += 1 - r;
        }

        // ── Test 9: negatives and positives, multiple triplets ────────────────
        {
            int r = check("Test 9  – [-4,-2,0,1,2,3] → [[-4,1,3],[-2,0,2]]",
                    sol.threeSum(new int[]{-4,-2,0,1,2,3}),
                    List.of(List.of(-4,1,3), List.of(-2,0,2)));
            failed += r; passed += 1 - r;
        }

        // ── Test 10: two elements only — impossible ────────────────────────────
        {
            int r = check("Test 10 – [0,0] → []  (need at least 3 elements)",
                    sol.threeSum(new int[]{0,0}),
                    List.of());
            failed += r; passed += 1 - r;
        }

        // ── Test 11: large number of duplicates ───────────────────────────────
        {
            // [-1,-1,-1,2,2,2] → [-1,-1,2] only, no duplicates in output
            int r = check("Test 11 – [-1,-1,-1,2,2,2] → [[-1,-1,2]]",
                    sol.threeSum(new int[]{-1,-1,-1,2,2,2}),
                    List.of(List.of(-1,-1,2)));
            failed += r; passed += 1 - r;
        }

        System.out.println("\n──────────────────────────────");
        System.out.printf("  Results: %d passed, %d failed%n", passed, failed);
        System.out.println("──────────────────────────────");
    }

    // ─── Comparison helper (order-insensitive) ────────────────────────────────
    // Sorts each triplet and the list of triplets before comparing,
    // so your solution doesn't need to return results in any specific order.
    private static int check(String name,
                             List<List<Integer>> actual,
                             List<List<Integer>> expected) {
        List<List<Integer>> normActual   = normalize(actual);
        List<List<Integer>> normExpected = normalize(expected);

        if (normActual.equals(normExpected)) {
            System.out.printf("  ✓ %s%n", name);
            return 0;
        } else {
            System.out.printf("  ✗ %s%n    expected %s%n    got      %s%n",
                    name, normExpected, normActual);
            return 1;
        }
    }

    private static List<List<Integer>> normalize(List<List<Integer>> triplets) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> t : triplets) {
            List<Integer> sorted = new ArrayList<>(t);
            Collections.sort(sorted);
            copy.add(sorted);
        }
        copy.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });
        return copy;
    }
}