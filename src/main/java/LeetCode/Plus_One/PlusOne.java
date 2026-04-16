package LeetCode.Plus_One;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 3};
        System.out.println("[1,2,4] => " + Arrays.toString(plusOne(list1)));

        int[] list2 = {9};
        System.out.println("[1,2,4] => " + Arrays.toString(plusOne(list2)));
    }

    public static int[] plusOne(int[] digits) {
        boolean increaseArraySize = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                if (i - 1 < 0) {
                    increaseArraySize = true;
                }

                digits[i] = 0;
            }
        }

        if (increaseArraySize) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }

        return digits;
    }
}
