package leetcode.p53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                dp[0] = nums[0];
            }else {
                if (dp[i-1] > 0) {
                    dp[i] = dp[i-1] + nums[i];
                }else {
                    dp[i] = nums[i];
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int ele : dp) {
            if (ele > maxSum) {
                maxSum = ele;
            }
        }
        return maxSum;
    }
}
