package leetcode.p2412;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long minimumMoney(int[][] transactions) {
        int consumeReturnMax = 0;
        int notConsumeConMax = 0;

        List<int[]> consumeList = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i][0] > transactions[i][1]) {
                if (transactions[i][1] >= consumeReturnMax) {
                    consumeReturnMax = transactions[i][1];
                }
                consumeList.add(transactions[i]);
            }else {
                if (transactions[i][0] >= notConsumeConMax) {
                    notConsumeConMax = transactions[i][0];
                }
            }
        }

        long leastMoney = notConsumeConMax;

        if (leastMoney > consumeReturnMax) {
            for (int[] ints : consumeList) {
                leastMoney += ints[0];
                leastMoney -= ints[1];
            }
        }else {
            leastMoney = 0;
            boolean visited = false;
            for (int[] ints : consumeList) {
                //found
                if (ints[1] == consumeReturnMax && !visited) {
                    leastMoney += ints[0];
                    visited = true;
                }else {
                    leastMoney += ints[0];
                    leastMoney -= ints[1];
                }

            }
        }

        return leastMoney;
    }
}
