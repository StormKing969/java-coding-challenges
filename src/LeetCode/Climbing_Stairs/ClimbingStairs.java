package LeetCode.Climbing_Stairs;

/**
 * LeetCode 70. Climbing Stairs
 * <p>
 * Problem: You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * Solution Explanation:
 * This is a classic dynamic programming problem that follows the Fibonacci sequence pattern.
 * To reach step 'n', you can either:
 * 1. Come from step 'n-1' by taking a 1-step jump.
 * 2. Come from step 'n-2' by taking a 2-step jump.
 * Therefore, the total ways to reach step 'n' is the sum of ways to reach 'n-1' and 'n-2'.
 * Total ways(n) = ways(n-1) + ways(n-2)
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1) as we only store the last two results.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        // Example test cases
        System.out.println("2 steps => " + climbStairs(2) + " ways (Expected: 2)");
        System.out.println("5 steps => " + climbStairs(5) + " ways (Expected: 8)");
    }

    /**
     * Calculates the number of ways to climb n stairs.
     * @param n The number of steps to reach the top.
     * @return The number of distinct ways to reach the top.
     */
    public static int climbStairs(int n) {
        // Base cases: if there are 0 or 1 steps, there is only 1 way to be at that position.
        if (n == 0 || n == 1) {
            return 1;
        }

        // We use two variables to store the number of ways to reach the previous two steps.
        // prev: ways to reach (i-2), curr: ways to reach (i-1)
        int prev = 1, curr = 1;

        // Iterate from step 2 up to n.
        for (int i = 2; i <= n; i++) {
            // Calculate ways for current step: ways(i-1) + ways(i-2)
            int temp = curr;
            curr = prev + curr;
            // Update prev for the next iteration (it becomes what was curr in the previous step)
            prev = temp;
        }

        return curr;
    }
}
