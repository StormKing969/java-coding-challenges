package LeetCode.Non_Overlapping_Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] list = { {1, 2}, {2, 3}, {3, 4}, {1, 3} };
        System.out.println("1 => " + eraseOverlapIntervals(list));

        int[][] list2 = { {1, 100}, {11, 22}, {1, 11}, {2, 12} };
        System.out.println("2 => " + eraseOverlapIntervals(list2));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int counter = 0;
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                counter++;
            } else {
                prev_end = intervals[i][1];
            }
        }

        return counter;
    }
}
