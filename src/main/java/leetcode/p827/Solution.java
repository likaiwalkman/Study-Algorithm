package leetcode.p827;

import java.util.*;

public class Solution {

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, Integer> islandAreaIndex = new HashMap<>();
        int count = 1;
        int largestArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int[] area = new int[1];
                visit(grid, i, j, m, n, area, 1, Integer.MAX_VALUE);
                islandAreaIndex.put(count, area[0]);
                if (area[0] > largestArea) {
                    largestArea = area[0];
                }
                area[0] = 0;
                visit(grid, i, j, m, n, area, Integer.MAX_VALUE, count);
                count++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    Map<Integer, Integer> surroundings = new HashMap<>();
                    if (i-1 >=0 && grid[i-1][j] != 0){
                        addSurroundings(surroundings, grid[i-1][j], islandAreaIndex);
                    }
                    if (j-1 >=0 && grid[i][j-1] != 0){
                        addSurroundings(surroundings, grid[i][j-1], islandAreaIndex);
                    }
                    if (i+1 < m && grid[i+1][j] != 0){
                        addSurroundings(surroundings, grid[i+1][j], islandAreaIndex);
                    }
                    if (j+1 < n && grid[i][j+1] != 0){
                        addSurroundings(surroundings, grid[i][j+1], islandAreaIndex);
                    }
                    if (!surroundings.isEmpty()) {
                        int maxConnectedArea = 0;
                        for (Integer value : surroundings.values()) {
                            maxConnectedArea += value;
                        }
                        if (maxConnectedArea + 1 > largestArea){
                            largestArea = maxConnectedArea + 1;
                        }
                    }
                }
            }
        }
        return largestArea == 0 ? 1 : largestArea;
    }

    void visit(int[][] grid, int i, int j, int m, int n, int[] area, int expect, int newValue){
        if (grid[i][j] != expect){
            return;
        }
        grid[i][j] = newValue;
        area[0]++;
        if (i-1 >= 0){
            visit(grid, i-1, j, m, n, area, expect, newValue);
        }
        if (i+1 < m){
            visit(grid, i+1, j, m, n, area, expect, newValue);
        }
        if (j-1 >= 0){
            visit(grid, i, j-1, m, n, area, expect, newValue);
        }
        if (j+1 < n){
            visit(grid, i, j+1, m, n, area, expect, newValue);
        }
    }

    static void addSurroundings(Map<Integer, Integer> surroundings, int v, Map<Integer, Integer> islandAreaIndex){
        if (surroundings.containsKey(v)) {
            return;
        }
        surroundings.put(v, islandAreaIndex.get(v));
    }
}
