package LeetCode.Move_Zeroes;

import java.util.Arrays;
import java.util.Stack;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] list = new int[] {0,1,0,3,12};
        moveZeroes(list);
        int[] list2 = new int[] {0,1,0,3,12,3,4,5,6,0};
        moveZeroesV2(list2);
        System.out.println("[1,3,12,0,0] => " + Arrays.toString(list));
        System.out.println("[1,3,12,0,0] => " + Arrays.toString(list2));
    }

    public static void moveZeroes(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != 0) {
                stack.push(numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                numbers[i] = 0;
            } else {
                numbers[i] = stack.pop();
            }
        }
    }

    public static void moveZeroesV2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] != 0) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                        break;
                    }
                }
            }
        }
    }


}
