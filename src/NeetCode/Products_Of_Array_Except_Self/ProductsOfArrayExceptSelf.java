package NeetCode.Products_Of_Array_Except_Self;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfV2(new int[]{1, 2, 4, 6})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,0,1,2,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[]{};
        int totalProduct = 1;
        for (int ele : nums) {
            totalProduct *= ele;
        }

        int[] answer = new int[nums.length];
        Arrays.fill(answer, totalProduct);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] == 1) continue;
            answer[i] = totalProduct / nums[i];
        }

        return answer;
    }

    public static int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
