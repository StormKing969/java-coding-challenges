package LeetCode.Remove_Duplicates_From_Sorted_Array;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2};
        System.out.println("2 => " + removeDuplicates(arr1));

//        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println("5 => " + removeDuplicates(arr2));

        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("5 => " + removeDuplicatesV2(arr2));
    }

    public static int removeDuplicates(int[] numbers) {
        List<Integer> temp = new ArrayList<>();
        temp.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                temp.add(numbers[i]);
            }
        }

        return temp.size();
    }

    public static int removeDuplicatesV2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int indexCounter = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                numbers[indexCounter] = numbers[i];
                indexCounter++;
            }
        }

        return indexCounter;
    }
}
