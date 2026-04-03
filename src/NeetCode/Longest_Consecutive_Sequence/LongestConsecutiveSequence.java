package NeetCode.Longest_Consecutive_Sequence;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println("4 => " + longestConsecutive(new int[]{2,20,4,10,3,4,5}));
        System.out.println("7 => " + longestConsecutive(new int[]{0,3,2,5,4,6,1,1}));
        System.out.println("7 => " + longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
        System.out.println("4 => " + longestConsecutive(new int[]{2,20,4,10,3,4,5}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);
        int max = 1;
        int currentMax = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - current == 1) {
                currentMax++;
            } else if (nums[i] == current) {
                continue;
            } else {
                if (max < currentMax) {
                    max = currentMax;
                }
                currentMax = 1;
            }

            current = nums[i];
        }

        if (max < currentMax) {
            max = currentMax;
        }

        return max;
    }
}
