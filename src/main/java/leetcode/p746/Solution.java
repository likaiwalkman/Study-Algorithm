package leetcode.p746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] results = new int[cost.length];
        results[0] = cost[0];
        results[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            results[i] = Math.min(results[i-1], results[i-2]) + cost[i];
        }
        return Math.min(results[results.length-1], results[results.length-2]);
    }
}
