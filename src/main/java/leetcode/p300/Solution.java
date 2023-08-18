package leetcode.p300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j]+1 > temp) {
                        temp = dp[j]+1;
                    }
                }
            }
            dp[i] = temp;
        }
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
