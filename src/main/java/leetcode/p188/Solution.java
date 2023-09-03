package leetcode.p188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[k+1][];
            for (int j = 0; j < k+1; j++) {
                dp[i][j] = new int[2];
            }

        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y <= k; y++) {
                for (int z = 0; z <= 1; z++) {
                    if (x == 0) {
                        if (z == 1){
                            dp[x][y][z] = -prices[x];
                        }else if (z==0){
                            dp[x][y][z] = 0;
                        }
                        continue;
                    }
                    if (y==0){
                        dp[x][y][0] = 0;

                    }else {
                        dp[x][y][0] = Math.max(dp[x-1][y-1][1]+prices[x], dp[x-1][y][0]);
                    }
                    dp[x][y][1] = Math.max(dp[x-1][y][0]-prices[x], dp[x-1][y][1]);
                }
            }
        }
        return dp[n-1][k][0];
    }
}
