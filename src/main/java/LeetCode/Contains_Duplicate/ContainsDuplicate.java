package LeetCode.Contains_Duplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }

            map.put(i, 1);
        }

        return false;
    }
}
