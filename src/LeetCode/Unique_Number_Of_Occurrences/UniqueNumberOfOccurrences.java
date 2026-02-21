package LeetCode.Unique_Number_Of_Occurrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println("true => " + uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println("false => " + uniqueOccurrences(new int[]{1,2}));
        System.out.println("true => " + uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int value : map.values()) {
            if (list.contains(value)) {
                return false;
            } else {
                list.add(value);
            }
        }

        return true;
    }
}
