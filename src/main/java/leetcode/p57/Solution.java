package leetcode.p57;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = -1;
        int end = -1;
        for (int j = 0; j < intervals.length; j++) {
            boolean notMergeAble = intervals[j][0] > newInterval[1] || intervals[j][1] < newInterval[0];
            if (!notMergeAble){
                end = j;
                if (start == -1) {
                    start = j;
                }
            }
        }
        if (end == -1) {
            int[][] results = new int[intervals.length+1][];
            int index = 0;
            boolean prio = true;
            for (int i = 0; i < intervals.length; i++) {
                if (newInterval[0] < intervals[i][0] && prio) {
                    results[index++] = newInterval;
                    results[index++] = intervals[i];
                    prio = false;
                }else {
                    results[index++] = intervals[i];
                }
            }
            if (results[results.length-1] == null) {
                results[index] = newInterval;
            }
            return results;
        }

        int newLen = start + (intervals.length-end);
        int[][] results = new int[newLen][];
        int index = 0;
        for (int i = 0; i <= start-1; i++) {
            results[index++] = intervals[i];
        }

        int min = Math.min(intervals[start][0], newInterval[0]);
        int max = Math.max(intervals[end][1], newInterval[1]);
        results[index++] = new int[]{min, max};

        for (int i = end+1; i < intervals.length; i++) {
            results[index++] = intervals[i];
        }

        return results;
    }
}
