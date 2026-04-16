package NeetCode.Three_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(threeSum(new int[]{0,0,0,0}));
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        if (nums.length == 0) return returnList;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = firstNumber + nums[left] + nums[right];
                if (sum == 0) {
                    temp.add(List.of(firstNumber, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        returnList.addAll(temp);
        return returnList;
    }
}
