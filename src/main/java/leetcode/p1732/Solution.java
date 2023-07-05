package leetcode.p1732;

public class Solution {
    public int largestAltitude(int[] gain) {
        int[] heights = new int[gain.length+1];
        heights[0]=0;
        for (int i = 1; i < heights.length; i++) {
            heights[i] = heights[i-1]+gain[i-1];
        }
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }
}
