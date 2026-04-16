package LeetCode.Best_Time_To_Buy_And_Sell_Stock;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("4 => " + maxProfit(new int[]{3,2,6,5,0,3}));
        System.out.println("2 => " + maxProfit(new int[]{2,4,1}));
        System.out.println("0 => " + maxProfit(new int[]{7,6,4,3,1}));
        System.out.println("3 => " + maxProfit(new int[]{1,2,4}));
        System.out.println("5 => " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("0 => " + maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;

        int min = prices[0];
        int max = 0;
        int difference = max - min;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i + 1];
            } else {
                if (max < prices[i]) {
                    max = prices[i];
                }
            }

            if (max - min > difference) {
                difference = max - min;
            }
        }

        max = Math.max(max, prices[prices.length - 1]);
        if (max - min > difference) {
            difference = max - min;
        }

        return Math.max(difference, 0);
    }
}
