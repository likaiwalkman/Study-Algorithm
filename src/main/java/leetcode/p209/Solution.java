package leetcode.p209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (j < nums.length){
            sum += nums[j];
            while (sum >= target){
                int temp = j-i+1;
                if (temp < result) {
                    result = temp;
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (result == Integer.MAX_VALUE){
            return 0;
        }else {
            return result;
        }
    }
}
