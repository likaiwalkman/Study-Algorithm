package leetcode.p121;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] ints = new int[prices.length-1];

        for (int i = 0; i < prices.length - 1; i++) {
            ints[i] = prices[i+1] - prices[i];
        }
        int maxDiff = 0;
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= 0) {
                sum += ints[i];
            }else {
                if (sum > maxDiff) {
                    maxDiff = sum;
                }
                sum = 0;
            }
        }


        return maxDiff;
    }
}
