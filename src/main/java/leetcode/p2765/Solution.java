package leetcode.p2765;

public class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxLen = -1;

        for (int i = 1; i < nums.length;) {
            int sum = nums[i] + nums[i-1];
            int len = 0;
            int j = i;
            int sign = 1;
            while (j < nums.length && nums[j]-nums[j-1] == sign && nums[j]+nums[j-1] == sum) {
                if (len == 0){
                    len += 2;
                }else {
                    len += 1;
                }
                j++;
                sign = -1 * sign;
            }
            if (len !=0 && len > maxLen) {
                maxLen = len;
            }
            if (i == j) {
                i++;
            }else {
                i = j;
            }
        }

        return maxLen;
    }
}
