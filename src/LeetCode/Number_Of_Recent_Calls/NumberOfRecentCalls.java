package LeetCode.Number_Of_Recent_Calls;

public class NumberOfRecentCalls {
    private static final int[] records = new int[10000]; //
    private static int start;
    private static int end;

    public NumberOfRecentCalls() {
        start = 0;
        end = 0;
    }

    public static int ping(int t) {
        while (start < end && (t - records[start] > 3000)) {
            start++;
        }

        records[end++] = t;
        return end - start;
    }
}
