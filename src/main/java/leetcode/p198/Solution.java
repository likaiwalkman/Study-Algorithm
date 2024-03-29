package leetcode.p198;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];



        for (int i = 2; i < nums.length; i++) {
            dp[i] = dp[i-2] + nums[i];
            int temp = 0;
            if (i>=3){
                temp = dp[i-3] + nums[i];
                if (temp > dp[i]) {
                    dp[i] = temp;
                }
            }
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}
