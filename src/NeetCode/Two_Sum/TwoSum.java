package NeetCode.Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 4, 5, 6}, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] returnArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                returnArray[0] = map.get(nums[i]);
                returnArray[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return returnArray;
    }
}
