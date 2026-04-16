package LeetCode.Three_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        System.out.println("[[-1,-1,2],[-1,0,1]] = " + threeSum(numbers));

        int[] numbers2 = {0,1,1};
        System.out.println("[] = " + threeSum(numbers2));

        int[] numbers3 = {0, 0, 0};
        System.out.println("[[0,0,0]] = " + threeSum(numbers3));

        int[] numbers4 = {-100,-70,-60,110,120,130,160};
        System.out.println("[[-100,-60,160],[-70,-60,130]] = " + threeSum(numbers4));

        int[] numbers5 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println("[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]] = " + threeSum(numbers5));
    }

    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) return new ArrayList<>();

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;

            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    while (left < right && numbers[left] == numbers[left + 1]) left++;
                    while (left < right && numbers[right] == numbers[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
