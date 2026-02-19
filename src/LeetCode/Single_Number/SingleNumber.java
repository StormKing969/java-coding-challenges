package LeetCode.Single_Number;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{1,3,1,-1,3}));
        System.out.println(singleNumber(new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
    }

    public static int singleNumber(int[] numbers) {
        Arrays.sort(numbers);
        int answer = numbers[0];
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] == numbers[i + 1] && numbers[i] == answer) {
                answer = numbers[i + 2];
            }
        }

        return answer;
    }
}
