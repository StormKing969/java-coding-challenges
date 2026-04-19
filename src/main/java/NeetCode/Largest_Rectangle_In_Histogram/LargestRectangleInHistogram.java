package NeetCode.Largest_Rectangle_In_Histogram;

public class LargestRectangleInHistogram {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Brute force O(n²): for every pair of indices (i, j), find the min height
    // in that range and compute width * minHeight. Works within constraints.
    //
    // Optimal O(n) uses a monotonic stack. The key insight:
    //
    //   A bar at index i can extend leftward as long as bars to its left
    //   are >= its height. The moment you hit a shorter bar, it stops.
    //
    // Store indices of bars in a stack in increasing height order.
    // When you find a bar shorter than the top of the stack, the top bar
    // can no longer extend rightward — calculate its max rectangle now.
    //
    //   area = height[top] * (current_index - new_top_index - 1)
    //
    // Tip: appending a sentinel height of 0 at the end flushes
    // all remaining bars from the stack cleanly.

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int currentWidth = 1;
            // In Front
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < currentHeight) {
                    break;
                } else {
                    currentWidth++;
                }
            }

            // Behind
            for (int k = i - 1; k >= 0; k--) {
                if (heights[k] < currentHeight) {
                    break;
                } else {
                    currentWidth++;
                }
            }
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        int passed = 0, failed = 0;

        // ── Test 1: example 1 ─────────────────────────────────────────────────
        {
            // [7,1,7,2,2,4] → best is width 4 * height 2 = 8
            int r = check("Test 1  – [7,1,7,2,2,4] → 8",
                    sol.largestRectangleArea(new int[]{7,1,7,2,2,4}), 8);
            failed += r; passed += 1 - r;
        }

        // ── Test 2: example 2 ─────────────────────────────────────────────────
        {
            // [1,3,7] → single tallest bar: 1 * 7 = 7
            int r = check("Test 2  – [1,3,7] → 7",
                    sol.largestRectangleArea(new int[]{1,3,7}), 7);
            failed += r; passed += 1 - r;
        }

        // ── Test 3: single bar ────────────────────────────────────────────────
        {
            int r = check("Test 3  – [5] → 5",
                    sol.largestRectangleArea(new int[]{5}), 5);
            failed += r; passed += 1 - r;
        }

        // ── Test 4: all bars same height ──────────────────────────────────────
        {
            // width 4 * height 3 = 12
            int r = check("Test 4  – [3,3,3,3] → 12",
                    sol.largestRectangleArea(new int[]{3,3,3,3}), 12);
            failed += r; passed += 1 - r;
        }

        // ── Test 5: strictly ascending ────────────────────────────────────────
        {
            // [1,2,3,4,5] → best is 1*5=5 or 2*4=8 or 3*3=9: answer is 9
            int r = check("Test 5  – [1,2,3,4,5] → 9",
                    sol.largestRectangleArea(new int[]{1,2,3,4,5}), 9);
            failed += r; passed += 1 - r;
        }

        // ── Test 6: strictly descending ───────────────────────────────────────
        {
            // [5,4,3,2,1] → best is 1*5=5 or 2*4=8 or 3*3=9: answer is 9
            int r = check("Test 6  – [5,4,3,2,1] → 9",
                    sol.largestRectangleArea(new int[]{5,4,3,2,1}), 9);
            failed += r; passed += 1 - r;
        }

        // ── Test 7: valley in the middle ─────────────────────────────────────
        {
            // [4,1,4] → the valley of height 1 spans width 3 = 3,
            // or a single bar of height 4 = 4. Answer is 4.
            int r = check("Test 7  – [4,1,4] → 4",
                    sol.largestRectangleArea(new int[]{4,1,4}), 4);
            failed += r; passed += 1 - r;
        }

        // ── Test 8: peak in the middle ────────────────────────────────────────
        {
            // [1,5,1] → peak height 5 width 1 = 5, or full span height 1 * 3 = 3
            int r = check("Test 8  – [1,5,1] → 5",
                    sol.largestRectangleArea(new int[]{1,5,1}), 5);
            failed += r; passed += 1 - r;
        }

        // ── Test 9: contains a zero-height bar ────────────────────────────────
        {
            // [3,0,3] → zero splits the histogram; each side gives 3, answer 3
            int r = check("Test 9  – [3,0,3] → 3  (zero bar splits histogram)",
                    sol.largestRectangleArea(new int[]{3,0,3}), 3);
            failed += r; passed += 1 - r;
        }

        // ── Test 10: wide flat region beats a tall narrow bar ─────────────────
        {
            // [2,2,2,2,2,10] → flat region: 5*2=10 ties with single bar 10
            // answer is 10
            int r = check("Test 10 – [2,2,2,2,2,10] → 12",
                    sol.largestRectangleArea(new int[]{2,2,2,2,2,10}), 12);
            failed += r; passed += 1 - r;
        }

        // ── Test 11: large uniform block ─────────────────────────────────────
        {
            // [6,6,6,6] → 4 * 6 = 24
            int r = check("Test 11 – [6,6,6,6] → 24",
                    sol.largestRectangleArea(new int[]{6,6,6,6}), 24);
            failed += r; passed += 1 - r;
        }

        // ── Test 12: two bars, shorter one limits span ────────────────────────
        {
            // [3,6] → single bar 6, or span 2*3=6: answer 6
            int r = check("Test 12 – [3,6] → 6",
                    sol.largestRectangleArea(new int[]{3,6}), 6);
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
