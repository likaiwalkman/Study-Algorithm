package leetcode.p48;

import java.util.LinkedList;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int bottom = n-1;

        LinkedList<Integer> visited = new LinkedList<>();
        while (bottom > top){

            //collect
            for (int i = top; i <=bottom ; i++) {
                visited.add(matrix[top][i]);
            }
            for (int i = top+1; i <=bottom ; i++) {
                visited.add(matrix[i][bottom]);
            }
            for (int i = bottom-1; i >= top ; i--) {
                visited.add(matrix[bottom][i]);
            }
            for (int i = bottom-1; i >= top+1 ; i--) {
                visited.add(matrix[i][top]);
            }

            //put
            for (int i = top; i <=bottom ; i++) {
                matrix[i][bottom] = visited.poll();
            }
            for (int i = bottom-1; i >= top ; i--) {
                matrix[bottom][i] = visited.poll();
            }
            for (int i = bottom-1; i >= top ; i--) {
                matrix[i][top] = visited.poll();
            }
            for (int i = top+1; i < bottom ; i++) {
                matrix[top][i] = visited.poll();
            }

            top++;
            bottom--;
        }

    }
}
