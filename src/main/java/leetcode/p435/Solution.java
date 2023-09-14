package leetcode.p435;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int result = 0;
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[j][0] < intervals[i][1]){
                result++;
            }else {
                i = j;
            }
        }
        return result;
    }
}
