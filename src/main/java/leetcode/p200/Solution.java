package leetcode.p200;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                total++;
                mark(grid, i, j, m, n);
            }
        }
        return total;
    }

    void mark(char[][] grid, int i, int j, int m, int n){
        if (grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        if (i-1 >= 0){
            mark(grid, i-1, j, m, n);
        }
        if (i+1 < m){
            mark(grid, i+1, j, m, n);
        }
        if (j-1 >= 0){
            mark(grid, i, j-1, m, n);
        }
        if (j+1 < n){
            mark(grid, i, j+1, m, n);
        }
    }
}
