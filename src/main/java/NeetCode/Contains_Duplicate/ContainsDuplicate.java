package NeetCode.Contains_Duplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1,2,2,3}));
    }

    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, 1);
        }

        return false;
    }
}
