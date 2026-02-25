package NeetCode.Top_K_Frequent_Elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,2,3,3,3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 2, 3, 3, 3, 1, 2, 3, 1, 1, 1}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int[] returnOutput = new int[k];
        for (int i = 0; i < k; i++) {
            int max = 0;
            for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
                if (ele.getValue() >= max) {
                    returnOutput[i] = ele.getKey();
                    max = ele.getValue();
                }
            }
            map.remove(returnOutput[i]);
        }

        return returnOutput;
    }
}
