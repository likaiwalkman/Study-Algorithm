package leetcode.p17_08;

import java.util.Arrays;

public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0){
            return 0;
        }
        int[][] array = new int[height.length][];
        for (int i = 0; i < height.length; i++) {
            array[i] = new int[2];
            array[i][0] = height[i];
            array[i][1] = weight[i];
        }

        Arrays.sort(array, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] ints = new int[height.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = array[i][1];
        }
        int i = lengthOfLIS(ints);
        return i;
    }

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
