package leetcode.p45;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < nums.length; i++) {
            int minJumps = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    int possibleMinJumps = 1 + dp[j];
                    if (minJumps > possibleMinJumps) {
                        minJumps = possibleMinJumps;
                    }
                }
            }
            dp[i] = minJumps;
            System.out.println();
        }
        return dp[nums.length-1];
    }
}
