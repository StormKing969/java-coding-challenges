package LeetCode.Product_Of_Array_Except_Self;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] list1 = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(list1)));
    }

    public static int[] productExceptSelf(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= numbers[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= numbers[i];
        }

        return result;
    }
}
