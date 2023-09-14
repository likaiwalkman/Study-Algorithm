package leetcode.p2352;

import java.util.*;

public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, List<Integer>> rowMap = new HashMap<>();
        Map<List<Integer>, List<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> key = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                key.add(grid[i][j]);
            }
            if (!rowMap.containsKey(key)) {
                rowMap.put(key, new ArrayList<>());
            }
            rowMap.get(key).add(i);
        }


        for (int i = 0; i < n; i++) {
            List<Integer> key = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                key.add(grid[j][i]);
            }
            if (!colMap.containsKey(key)) {
                colMap.put(key, new ArrayList<>());
            }
            colMap.get(key).add(i);
        }

        Set<Map.Entry<List<Integer>, List<Integer>>> entries = rowMap.entrySet();
        int reuslt = 0;
        for (Map.Entry<List<Integer>, List<Integer>> entry : entries) {
            if (colMap.containsKey(entry.getKey())) {
                reuslt += entry.getValue().size() * colMap.get(entry.getKey()).size();
            }
        }
        return reuslt;
    }
}
