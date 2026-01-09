package LeetCode.Edit_Distance;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;

        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j) {
                char word1Letter = word1.charAt(i - 1);
                char word2Letter = word2.charAt(j - 1);
                if (word1Letter == word2Letter)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }

        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        return dp[m][n];
    }
}
