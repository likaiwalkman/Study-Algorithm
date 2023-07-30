package leetcode.p73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] lines = new int[m];
        int[] cols  = new int[n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (lines[i] != 1){
                        lines[i] = 1;
                    }
                    if (cols[j] != 1){
                        cols[j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 0) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
