package leetcode.p643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        int lastIndex = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        for (int i = 1; i <= nums.length - k; i++) {
            sum += nums[i+k-1];
            sum -= nums[lastIndex];

            if (sum > maxSum) {
                maxSum = sum;
            }
            lastIndex++;
        }

        double v = maxSum * 1.0 / k;
        return v;

    }
}
