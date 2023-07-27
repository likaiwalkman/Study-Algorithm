package leetcode.p59;

public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[n];
        }
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        int count = 1;
        while (top < bottom && left < right ){

            for (int i = left; i < right; i++) {
                if (top < matrix.length){
                    matrix[top][i] = count++;
                }
            }
            top++;
            if (top == bottom){
                break;
            }


            for (int i = top; i < bottom; i++) {
                if (right-1 >= 0){
                    matrix[i][right-1] = count++;
                }
            }
            right--;
            if (left == right){
                break;
            }

            for (int i = right-1; i >= left; i--) {
                if (i >= 0){
                    matrix[bottom-1][i] = count++;
                }
            }
            bottom--;
            if (top == bottom){
                break;
            }

            for (int i = bottom-1; i >= top; i--) {
                if (i >=0 ){
                    matrix[i][left] = count++;;
                }
            }
            left++;
        }
        return matrix;
    }
}
