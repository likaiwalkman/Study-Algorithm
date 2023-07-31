package leetcode.p238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] L = new int[nums.length-1];
        L[0] = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            L[i] = nums[i] * L[i-1];
        }
        int[] R = new int[nums.length-1];
        R[0] = nums[nums.length-1];

        for (int i = 1; i <= nums.length - 2; i++) {
            R[i] = R[i-1] * nums[nums.length-1-i];
        }


        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            if (i-1 >= 0){
                result[i] *= L[i-1];
            }
            if (i+1<nums.length){
                result[i] *= R[nums.length-1-i-1];
            }
        }
        return result;
    }
}
