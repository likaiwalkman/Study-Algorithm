package leetcode.p724;

public class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0){
                prefixSum += nums[i-1];
            }
            if (prefixSum == total-prefixSum-nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
