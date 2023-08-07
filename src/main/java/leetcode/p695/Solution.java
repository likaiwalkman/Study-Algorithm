package leetcode.p695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int[] area = new int[1];
                visit(grid, i, j, m, n, area);
                if (area[0] > maxArea) {
                    maxArea = area[0];
                }

            }
        }
        return maxArea;
    }

    void visit(int[][] grid, int i, int j, int m, int n, int[] area){
        if (grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        area[0]++;
        if (i-1 >= 0){
            visit(grid, i-1, j, m, n, area);
        }
        if (i+1 < m){
            visit(grid, i+1, j, m, n, area);
        }
        if (j-1 >= 0){
            visit(grid, i, j-1, m, n, area);
        }
        if (j+1 < n){
            visit(grid, i, j+1, m, n, area);
        }
    }
}
