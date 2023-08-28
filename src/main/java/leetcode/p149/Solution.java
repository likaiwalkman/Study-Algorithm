package leetcode.p149;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2){
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int verticalCount = 0;
            if (i == 2) {
                System.out.println();
            }
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                if (points[j][0] == points[i][0]) {
                    verticalCount++;
                }else {
                    double k = 1.0D * (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    if (!map.containsKey(k)) {
                        map.put(k, 1);
                    }else {
                        map.put(k, map.get(k)+1);
                    }
                }
            }
            verticalCount++;
            Integer max = Integer.MIN_VALUE;
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            max++;
            if (Math.max(max, verticalCount) > result) {
                result = Math.max(max, verticalCount);
            }
        }
        return result;
    }
}
