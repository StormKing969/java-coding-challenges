package LeetCode.Maximum_Subarray;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("-1 => " + maxSubArray(new int[]{-2,-1}));
        System.out.println("6 => " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("1 => " + maxSubArray(new int[]{1}));
        System.out.println("23 => " + maxSubArrayV2(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;

        int answer = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentSum = nums[i];
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp > currentSum) {
                    currentSum = temp;
                }
            }

            answer = Math.max(answer, currentSum);
        }

        return answer;
    }

    public static int maxSubArrayV2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
