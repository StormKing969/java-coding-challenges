package NeetCode.Two_Integer_Sum_II;

import java.util.Arrays;

public class TwoIntegerSumII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }

        return new int[0];
    }
}
