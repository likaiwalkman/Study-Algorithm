package leetcode.p11;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int lo = 0;
        int hi = height.length-1;
        int minHeight = Integer.MAX_VALUE;
        while (hi > lo) {
            if (height[lo] < height[hi]) {
                minHeight = height[lo];
                lo++;
            }else {
                minHeight = height[hi];
                hi--;
            }
            int area = minHeight * (hi - lo + 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
