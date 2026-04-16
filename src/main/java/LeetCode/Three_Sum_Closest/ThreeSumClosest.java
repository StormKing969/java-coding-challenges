package LeetCode.Three_Sum_Closest;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] numbers = {-1,2,1,-4};
        System.out.println("2 = " + threeSumClosest(numbers, 1));

        int[] numbers2 = {0,0,0};
        System.out.println("0 = " + threeSumClosest(numbers2, 1));

        int[] numbers3 = {0,1,2};
        System.out.println("3 = " + threeSumClosest(numbers3, 3));

        int[] numbers4 = {1,1,1,1};
        System.out.println("3 = " + threeSumClosest(numbers4, 3));

        int[] numbers5 = {1,1,1,1};
        System.out.println("3 = " + threeSumClosest(numbers5, 0));

        int[] numbers6 = {1,1,1,0};
        System.out.println("3 = " + threeSumClosest(numbers6, 100));

        int[] numbers7 = {10,20,30,40,50,60,70,80,90};
        System.out.println("60 = " + threeSumClosest(numbers7, 1));

        int[] numbers8 = {-1,2,1,-4};
        System.out.println("2 = " + threeSumClosest(numbers8, 1));
    }

    public static int threeSumClosest(int[] numbers, int target) {
        if (numbers.length <= 3) return Arrays.stream(numbers).sum();

        Arrays.sort(numbers);
        int answer = numbers[0] +  numbers[1] + numbers[2];
        int difference = Math.abs(target - answer);
        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                int diff = Math.abs(target - sum);
                if (diff == 0) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                if (diff < difference) {
                    difference = diff;
                    answer = sum;
                }
            }
        }

        return answer;
    }
}
