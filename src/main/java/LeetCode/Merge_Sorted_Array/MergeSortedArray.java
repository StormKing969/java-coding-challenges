package LeetCode.Merge_Sorted_Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,0,0,0};
        int[] array2 = {2,5,6};
        merge(array1, 3, array2, 3);
        System.out.println("[1,2,2,3,5,6] => " + Arrays.toString(array1));
    }

    public static void merge(int[] numbers1, int m, int[] numbers2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            numbers1[i] = numbers2[j];
            i++;
        }

        Arrays.sort(numbers1);
    }
}
