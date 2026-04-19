package NeetCode.Car_Fleet;

import java.util.Stack;

public class CarFleet {

    // ─── YOUR IMPLEMENTATION GOES BELOW ───────────────────────────────────────
    //
    // Key insight: process cars from closest-to-target down to furthest.
    // For each car, compute how long it takes to reach the target:
    //
    //     time = (double)(target - position[i]) / speed[i]
    //
    // A car catches up to the fleet ahead of it if its time is LESS than
    // or equal to the fleet in front — it merges and takes the slower time.
    // If its time is GREATER, it can never catch up → new fleet.
    //
    // Hint: a stack of arrival times makes this clean.
    // What should you do when the current car's time <= the top of the stack?

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1 && speed.length == 1) return 1;

        boolean sorted = false;
        while (!sorted) {
            sorted = true; // assume sorted
            for (int i = 0; i < position.length - 1; i++) {
                if (position[i] < position[i + 1]) {
                    int tempPosition = position[i];
                    int tempSpeed = speed[i];
                    position[i] = position[i + 1];
                    speed[i] = speed[i + 1];
                    position[i + 1] = tempPosition;
                    speed[i + 1] = tempSpeed;
                    sorted = false; // found a swap → not sorted
                }
            }
        }

        Stack<Double> numberFleets = new Stack<>();
        numberFleets.push((double)(target - position[0]) / speed[0]);
        for (int i = 1; i < position.length; i++) {
            double time = (double)(target - position[i]) / speed[i];
            if (time > numberFleets.peek()) {
                numberFleets.push(time);
            }
        }

        return numberFleets.size();
    }

    // ─── TEST HARNESS ─────────────────────────────────────────────────────────
    //  Run this file directly (Shift+F10 in IntelliJ) to check your solution.

    public static void main(String[] args) {
        CarFleet sol = new CarFleet();
        int passed = 0, failed = 0;

        // ── Test 1: example 1 — two cars merge exactly at target ──────────────
        {
            int r = check("Test 1  – [1,4] speed [3,2] target 10 → 1 fleet",
                    sol.carFleet(10, new int[]{1,4}, new int[]{3,2}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 2: example 2 — four cars, three fleets ───────────────────────
        {
            int r = check("Test 2  – [4,1,0,7] speed [2,2,1,1] target 10 → 3 fleets",
                    sol.carFleet(10, new int[]{4,1,0,7}, new int[]{2,2,1,1}), 3);
            failed += r; passed += 1 - r;
        }

        // ── Test 3: single car ────────────────────────────────────────────────
        {
            int r = check("Test 3  – single car → 1 fleet",
                    sol.carFleet(10, new int[]{5}, new int[]{2}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 4: all cars same speed, different positions → each its own fleet
        {
            // same speed means a trailing car can never close the gap
            int r = check("Test 4  – [1,2,3] speed [1,1,1] target 10 → 3 fleets",
                    sol.carFleet(10, new int[]{1,2,3}, new int[]{1,1,1}), 3);
            failed += r; passed += 1 - r;
        }

        // ── Test 5: faster car behind slower car — they merge ────────────────
        {
            // car at 1 (speed 10) catches car at 5 (speed 1) well before target
            int r = check("Test 5  – [1,5] speed [10,1] target 20 → 1 fleet",
                    sol.carFleet(20, new int[]{1,5}, new int[]{10,1}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 6: slower car behind faster car — can never catch up ─────────
        {
            // car at 1 (speed 1) can never catch car at 5 (speed 10)
            int r = check("Test 6  – [1,5] speed [1,10] target 20 → 2 fleets",
                    sol.carFleet(20, new int[]{1,5}, new int[]{1,10}), 2);
            failed += r; passed += 1 - r;
        }

        // ── Test 7: car catches fleet exactly at destination ──────────────────
        {
            // car at 0 (speed 2): time = 10/2 = 5.0
            // car at 2 (speed 1): time = 8/1  = 8.0  → separate fleet
            // car at 4 (speed 3): time = 6/3  = 2.0  → catches car at 2? No.
            //   sorted by pos desc: [4,2,0] times [2.0, 8.0, 5.0]
            //   4→time 2.0 (new fleet), 2→time 8.0 > 2.0 (new fleet),
            //   0→time 5.0 < 8.0 (merges) → 2 fleets
            int r = check("Test 7  – [4,2,0] speed [3,1,2] target 10 → 2 fleets",
                    sol.carFleet(10, new int[]{4,2,0}, new int[]{3,1,2}), 2);
            failed += r; passed += 1 - r;
        }

        // ── Test 8: all cars merge into one fleet ─────────────────────────────
        {
            // each trailing car is fast enough to catch the one ahead
            // [1,2,3] speeds [9,6,3] target 10
            // sorted desc by pos: pos=3 time=7/3≈2.33, pos=2 time=8/6≈1.33 ≤ 2.33 merge,
            // pos=1 time=9/9=1.0 ≤ 2.33 merge → 1 fleet
            int r = check("Test 8  – [1,2,3] speed [9,6,3] target 10 → 1 fleet",
                    sol.carFleet(10, new int[]{1,2,3}, new int[]{9,6,3}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 9: positions given out of order ──────────────────────────────
        {
            // same as test 1 but positions unsorted in input
            int r = check("Test 9  – unsorted input [4,1] speed [2,3] target 10 → 1 fleet",
                    sol.carFleet(10, new int[]{4,1}, new int[]{2,3}), 1);
            failed += r; passed += 1 - r;
        }

        // ── Test 10: three separate fleets, no merging ────────────────────────
        {
            // [1,3,5] speeds [1,1,1] target 10 — same speed, gaps never close
            int r = check("Test 10 – [1,3,5] speed [1,1,1] target 10 → 3 fleets",
                    sol.carFleet(10, new int[]{1,3,5}, new int[]{1,1,1}), 3);
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