package NeetCode.Container_With_Most_Water;

public class ContainerWithMostWater {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Brute force O(n²): try every pair of bars and track the max.
    //   area = (right - left) * Math.min(height[left], height[right])
    //
    // Optimal O(n) — two pointers:
    //
    //   Start with left = 0, right = n - 1 (widest possible container).
    //   At each step, compute the area and update the max.
    //   Then move the pointer pointing to the SHORTER bar inward.
    //
    // Why move the shorter side?
    //   The area is always limited by the shorter bar.
    //   Moving the taller side inward can only make things worse (same or
    //   smaller height, narrower width). Moving the shorter side gives you
    //   a chance to find a taller bar that beats the current area.

    public int maxArea(int[] height) {
        int maxVolume = 0;
        if (height.length == 0) return maxVolume;

        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                int width = j - i;
                int columnHeight = Math.min(height[j], height[i]);
                int volume = columnHeight * width;
                maxVolume = Math.max(maxVolume, volume);
            }
        }

        return maxVolume;
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        int passed = 0, failed = 0;

        // ── Test 1: example 1 ─────────────────────────────────────────────────
        {
            // bars 1 (h=7) and 7 (h=6): width=6, height=6, area=36
            int r = check("Test 1  – [1,7,2,5,4,7,3,6] → 36",
                    sol.maxArea(new int[]{1,7,2,5,4,7,3,6}), 36);
            failed += r; passed += 1 - r;
        }

        // ── Test 2: example 2 — all same height ───────────────────────────────
        {
            // width=2, height=2, area=4
            int r = check("Test 2  – [2,2,2] → 4",
                    sol.maxArea(new int[]{2,2,2}), 4);
            failed += r; passed += 1 - r;
        }

        // ── Test 3: two bars only ─────────────────────────────────────────────
        {
            int r = check("Test 3  – [3,5] → 3  (width=1, limited by shorter bar)",
                    sol.maxArea(new int[]{3,5}), 3);
            failed += r; passed += 1 - r;
        }

        // ── Test 4: ascending heights ─────────────────────────────────────────
        {
            // best is leftmost and rightmost: width=4, height=1, area=4
            // OR indices 1 and 4: width=3, height=2, area=6
            // OR indices 2 and 4: width=2, height=3, area=6
            // OR indices 3 and 4: width=1, height=4, area=4
            // actually best: 1 and 4 or 2 and 4 = 6... let's check 0 and 4: 1*4=4
            // 1 and 4: min(2,5)*3=6, 2 and 4: min(3,5)*2=6, 3 and 4: min(4,5)*1=4
            // → 6
            int r = check("Test 4  – [1,2,3,4,5] → 6",
                    sol.maxArea(new int[]{1,2,3,4,5}), 6);
            failed += r; passed += 1 - r;
        }

        // ── Test 5: descending heights ────────────────────────────────────────
        {
            // mirror of test 4 — answer is same by symmetry
            int r = check("Test 5  – [5,4,3,2,1] → 6",
                    sol.maxArea(new int[]{5,4,3,2,1}), 6);
            failed += r; passed += 1 - r;
        }

        // ── Test 6: tall bars at both ends ────────────────────────────────────
        {
            // [10,1,1,1,10]: best is indices 0 and 4: width=4, height=10, area=40
            int r = check("Test 6  – [10,1,1,1,10] → 40  (tall outer bars)",
                    sol.maxArea(new int[]{10,1,1,1,10}), 40);
            failed += r; passed += 1 - r;
        }

        // ── Test 7: tall bar in the middle ────────────────────────────────────
        {
            // [1,1,100,1,1]: the giant middle bar can't help much
            // best is 0 and 4: width=4, height=1, area=4
            int r = check("Test 7  – [1,1,100,1,1] → 4  (tall middle bar doesn't help)",
                    sol.maxArea(new int[]{1,1,100,1,1}), 4);
            failed += r; passed += 1 - r;
        }

        // ── Test 8: best answer is not the widest container ───────────────────
        {
            // [1,8,6,2,5,4,8,3,7]: classic LeetCode example
            // best is indices 1 and 8: min(8,7)*7=49
            int r = check("Test 8  – [1,8,6,2,5,4,8,3,7] → 49",
                    sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);
            failed += r; passed += 1 - r;
        }

        // ── Test 9: all zeros ─────────────────────────────────────────────────
        {
            int r = check("Test 9  – [0,0,0,0] → 0",
                    sol.maxArea(new int[]{0,0,0,0}), 0);
            failed += r; passed += 1 - r;
        }

        // ── Test 10: one bar is zero ───────────────────────────────────────────
        {
            // [0,5,5,5]: best is indices 1 and 3: width=2, height=5, area=10
            int r = check("Test 10 – [0,5,5,5] → 10  (zero bar on edge ignored)",
                    sol.maxArea(new int[]{0,5,5,5}), 10);
            failed += r; passed += 1 - r;
        }

        // ── Test 11: equal heights, wider is better ───────────────────────────
        {
            // [5,5,5,5,5]: best is 0 and 4: width=4, height=5, area=20
            int r = check("Test 11 – [5,5,5,5,5] → 20",
                    sol.maxArea(new int[]{5,5,5,5,5}), 20);
            failed += r; passed += 1 - r;
        }

        // ── Test 12: two tall bars surrounded by short ones ───────────────────
        {
            // [3,10,3,3,3,10,3]: best is indices 1 and 5: width=4, height=10, area=40
            int r = check("Test 12 – [3,10,3,3,3,10,3] → 40",
                    sol.maxArea(new int[]{3,10,3,3,3,10,3}), 40);
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