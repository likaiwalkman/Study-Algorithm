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
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
