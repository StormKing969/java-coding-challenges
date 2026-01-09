package LeetCode.Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println("[2,7,11,15] = [0,1] => " + Arrays.toString(twoSum(numbers, 9)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if (map.containsKey(target - value)) {
                return new int[]{map.get(target - value), 1};
            }

            map.put(value, i);
        }

        return new int[2];
    }
}
