package leetcode.p42;

public class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;

        int oldLimit = 0;
        while (height[i] <= oldLimit && i+1 < height.length) {
            i++;
        }
        while (height[j] <= oldLimit && j-1 >= 0 ) {
            j--;
        }

        int limit = Math.min(height[i], height[j]);

        int sum = 0;
        while (j-i > 1 && limit > oldLimit){
            int x = j-i+1;
            sum += x * (limit-oldLimit);
            for (int k = i; k <= j; k++) {
                if (height[k] <= oldLimit) {
                    continue;
                }
                if (height[k] >= limit) {
                    int minus = limit-oldLimit;
                    sum -= minus;
                }else if(height[k] < limit) {
                    int minus = height[k]-oldLimit;
                    sum -= minus;
                }
            }

            oldLimit = limit;
            while (height[i] <= oldLimit && i+1 < height.length) {
                i++;
            }
            while (height[j] <= oldLimit && j-1 >= 0 ) {
                j--;
            }
            limit = Math.min(height[i], height[j]);
        }
        return sum;
    }
}
