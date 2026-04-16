package LeetCode.Count_Special_Triplets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSpecialTriplets {
    public static void main(String[] args) {
        int[] inputTest01 = {6, 3, 6};
        System.out.println("Special Triplets count: " + amount(inputTest01)); // 1

        int[] inputTest02 = {4, 2, 3, 4, 6, 8};
        System.out.println("Special Triplets count: " + amount(inputTest02)); // 1

        int[] inputTest03 = {0,1,0,0};
        System.out.println("Special Triplets count: " + getCount2(inputTest03)); // 1

        int[] inputTest04 = {8,4,2,8,4};
        System.out.println("Special Triplets count: " + amount(inputTest04)); // 2

        int[] inputTest05 = {84,2,93,1,2,2,26};
        System.out.println("Special Triplets count: " + amount(inputTest05)); // 2

        int[] inputTest06 = {40,2,20,1,2};
        System.out.println("Special Triplets count: " + amount(inputTest06)); // 1

        int[] inputTest07 = {2, 2, 2, 1, 1, 2, 3, 2, 2};
        System.out.println("Special Triplets count: " + getCount2(inputTest07)); // 18

        int[] inputTest08 = {28,52,14,28,34,26,14,52};
        System.out.println("Special Triplets count: " + getCount2(inputTest08)); // 2
    }

    private static int amount(int[] numbers) {
        int currentCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            int checkValue = numbers[i] * 2;
            int firstIndexCount = 0;
            int lastIndexCount = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[j] == checkValue) {
                    firstIndexCount++;
                }
            }

            if (firstIndexCount == 0) {
                continue;
            }

            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[k] == checkValue) {
                    lastIndexCount++;
                }
            }

            if (firstIndexCount > 0 && lastIndexCount == 0) {
                firstIndexCount = 0;
            }

            currentCount += firstIndexCount * lastIndexCount;
        }

        return currentCount;
    }

    private static int getCount2(int[] numbers) {
        int currentCount = 0;

        Map<Integer, List<Integer>> numbersList = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersList.containsKey(numbers[i])) {
                List<Integer> currentList = numbersList.get(numbers[i]);
                currentList.add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                numbersList.put(numbers[i], newList);
            }
        }

        for (int i = 1; i < numbers.length - 1; i++) {
            int checkValue = numbers[i] * 2;
            int frequencyBefore = 0;
            int frequencyAfter = 0;

            if (numbersList.containsKey(checkValue)) {
                for (int ele : numbersList.get(checkValue)) {
                    if (ele > i) {
                        frequencyAfter++;
                    }

                    if (ele < i) {
                        frequencyBefore++;
                    }
                }
            }

            currentCount += frequencyBefore * frequencyAfter;
        }

        return currentCount;
    }
}