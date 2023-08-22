package leetcode.p918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(Math.max(nums[0], nums[1]), nums[0]+nums[1]);
        }
        int totalSum = 0;
        boolean allNegative = true;
        boolean allNonNegative = true;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
            }
            if (nums[i] >= 0){
                allNegative = false;
            }else {
                allNonNegative = false;
            }
            totalSum += nums[i];
        }
        if (allNegative){
            return maxVal;
        }

        if (allNonNegative) {
            return totalSum;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i] + dp[i-1];
            }
        }
        int maxDp = Integer.MIN_VALUE;
        for (int dpItem : dp) {
            if (dpItem > maxDp) {
                maxDp = dpItem;
            }
        }
        int maxSum = deMax(nums);
        return Math.max(maxDp, maxSum);
    }

    public int deMax(int[] nums){
        int[] prefixSum = new int[nums.length];
        int[] prefixMax = new int[nums.length];
        int[] suffixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                prefixSum[i] = nums[i];
                prefixMax[i] = nums[i];
            }else {
                prefixSum[i] = nums[i] + prefixSum[i-1];
                prefixMax[i] = Math.max(prefixMax[i-1], prefixSum[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                suffixSum[i] = nums[nums.length-1];
            }else {
                suffixSum[i] = nums[nums.length-1-i] +suffixSum[i-1];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            if (i==0){
                k = suffixSum[nums.length-i-1];
            }else {
                k = prefixMax[i-1] + suffixSum[nums.length-1-i];
            }
            if (k > maxSum) {
                maxSum = k;
            }
        }
        return maxSum;
    }
}
