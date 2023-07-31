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
                boolean valid = matrix[i-1][j-1] != '1';
                System.out.println("i="+i+", j="+j+" valid="+valid);
                if (valid) {
                    continue;
                }
                for (int z = 1; z < square; z++) {

                    boolean flag = z+i<=m && z+j <=n;
                    if (!flag){
                        break;
                    }
                    int i2 = z+i;
                    int j2 = z+j;
                    int p1 = arr[i2][j2];
                    int p2 = arr[i2][j-1];
                    int p3 = arr[i-1][j2];
                    int p4 = arr[i-1][j-1];

                    int d =  p1 - p2 - ( p3 - p4);
                    flag = flag && d == (z+1)*(z+1);
                    if (!flag){
                        break;
                    }
                    if (z > maxDiff) {
                        maxDiff = z;
                    }
                }
            }
        }
        return (maxDiff+1) * (maxDiff+1);
    }
}
