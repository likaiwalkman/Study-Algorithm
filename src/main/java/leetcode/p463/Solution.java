package leetcode.p463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] perimeter = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit(grid, i, j, m, n, perimeter);
            }
        }
        return perimeter[0];
    }

    void visit(int[][] grid, int i, int j, int m, int n, int[] perimeter){
        if (grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        if(i-1  < 0 || grid[i-1][j] == 0){
            perimeter[0]++;
        }
        if(j-1  < 0 || grid[i][j-1] == 0){
            perimeter[0]++;
        }
        if(i+1 >= m || grid[i+1][j] == 0){
            perimeter[0]++;
        }
        if(j+1 >= n || grid[i][j+1] == 0){
            perimeter[0]++;
        }

        if (i-1 >= 0){
            visit(grid, i-1, j, m, n, perimeter);
        }
        if (i+1 < m){
            visit(grid, i+1, j, m, n, perimeter);
        }
        if (j-1 >= 0){
            visit(grid, i, j-1, m, n, perimeter);
        }
        if (j+1 < n){
            visit(grid, i, j+1, m, n, perimeter);
        }
    }
}
