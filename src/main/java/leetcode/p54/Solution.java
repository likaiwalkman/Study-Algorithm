package leetcode.p54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        List<Integer> results = new ArrayList<>();
        while (top < bottom && left < right ){

            for (int i = left; i < right; i++) {
                if (top < matrix.length){
                    int v = matrix[top][i];
                    results.add(v);
                }
            }
            top++;
            if (top == bottom){
                break;
            }


            for (int i = top; i < bottom; i++) {
                if (right-1 >= 0){
                    int v = matrix[i][right-1];
                    results.add(v);
                }
            }
            right--;
            if (left == right){
                break;
            }

            for (int i = right-1; i >= left; i--) {
                if (i >= 0){
                    int v = matrix[bottom-1][i];
                    results.add(v);
                }
            }
            bottom--;
            if (top == bottom){
                break;
            }

            for (int i = bottom-1; i >= top; i--) {
                if (i >=0 ){
                    int v = matrix[i][left];
                    results.add(v);
                }
            }
            left++;
        }
        return results;
    }
}
