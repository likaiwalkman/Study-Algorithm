package leetcode.p221;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int square = Math.min(m, n);
        int[][] arr = new int[m+1][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[n+1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i-1][j] + (arr[i][j-1] - arr[i-1][j-1]);
                if(matrix[i-1][j-1] == '1'){
                    arr[i][j]++;
                }
            }
        }
        if (arr[m][n] == m*n){
            return square * square;
        }
        if (arr[m][n] == 0){
            return 0;
        }

        int maxDiff = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] != '1') {
                    continue;
                }
                int maxDiff0 = 1;
                if (maxDiff != 0) {
                    maxDiff0 = maxDiff+1;
                }
                for (int z = maxDiff0; z < square; z++) {
                    boolean flag1= z+i<=m && z+j <=n;
                    if (!flag1 || arr[z+i][z+j] - arr[z+i][j-1] - ( arr[i-1][z+j] - arr[i-1][j-1]) != (z+1)*(z+1)){
                        break;
                    }
                    maxDiff = z;
                }
            }
        }
        return (maxDiff+1) * (maxDiff+1);
    }
}
