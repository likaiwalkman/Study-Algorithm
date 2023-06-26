package leetcode.p121;

public class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > minVal) {
                int mayMaxProfit = prices[i] - minVal;
                if (mayMaxProfit > maxProfit) {
                    maxProfit = mayMaxProfit;
                }
            }
            if (prices[i] < minVal) {
                minVal = prices[i];
            }
        }
        return maxProfit;

    }
}
