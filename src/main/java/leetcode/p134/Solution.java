package leetcode.p134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        int[] diffs = new int[n];
        for (int i = 0; i < gas.length; i++) {
            diffs[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < n; ) {
            int remaining = 0;
            int j = i;
            int count = 0;
            while (diffs[j%n] + remaining>=0) {
                remaining += (gas[j%n] - cost[j%n]);
                if (j % n == i && ++count == 2){
                    return i;
                }
                j++;
            }
            i = j+1;
        }
        return -1;
    }
}
