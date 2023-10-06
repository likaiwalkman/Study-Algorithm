package leetcode.p435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int i = 0;
        while (i < intervals.length) {
            count++;
            int j = i+1;
            while (j < intervals.length && intervals[j][0] < intervals[i][1]) {
                j++;
            }
            i = j;
        }

        return intervals.length - count;
    }
}
