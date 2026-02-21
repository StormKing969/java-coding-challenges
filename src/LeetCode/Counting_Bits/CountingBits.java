package LeetCode.Counting_Bits;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println("[0,1,1] => " + Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] output = new int[n+1];
        for (int i = 0; i <= n; i++) {
            output[i] = output[i >> 1] + (i & 1);
        }

        return output;
    }
}
