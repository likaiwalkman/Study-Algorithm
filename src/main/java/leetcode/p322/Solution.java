package leetcode.p322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        int[] res = new int[amount+1];
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int leastCoins = -1;
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }else if (coin == i){
                    leastCoins = 1;
                }else {
                    int prev = res[i-coin];
                    if (prev == -1) {
                        continue;
                    }
                    int newLeastCoins = prev + 1;
                    if (leastCoins < 0) {
                        leastCoins = newLeastCoins;
                    }else {
                        if(newLeastCoins < leastCoins){
                            leastCoins = newLeastCoins;
                        }
                    }
                }
            }
            res[i] = leastCoins;
        }
        return res[amount];
    }
}
