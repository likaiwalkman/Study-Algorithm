package leetcode.p74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;

        int left = 0;
        int right = matrix[0].length-1;

        return searchMatrix(top, bottom, left, right, matrix, target);
    }

    public boolean searchMatrix(int top, int bottom, int left, int right, int[][] matrix, int target){
        if (matrix[top][left] == target) {
            return true;
        }
        if (matrix[bottom][right] == target){
            return true;
        }
        if (matrix[top][left] > target){
            return false;
        }
        if (matrix[bottom][right] < target){
            return false;
        }
        if (top == bottom && left == right){
            return matrix[top][left] == target;
        }
        if (top != bottom) {
            int mid = (top + bottom)/2;
            int diff = matrix[mid][right] - target;
            if (diff == 0){
                return true;
            }else if (diff > 0){
                return searchMatrix(top, mid, left, right, matrix, target);
            }else {
                int diff2 = matrix[mid+1][left] - target;
                if (diff2 ==0){
                    return true;
                }else if (diff2 > 0){
                    return false;
                }else {
                    return searchMatrix(mid+1, bottom, left, right, matrix, target);
                }
            }
        }else {
            int mid = (left + right)/2;
            int diff = matrix[top][mid] - target;
            if (diff == 0){
                return true;
            }else if (diff > 0){
                return searchMatrix(top, bottom, left, mid, matrix, target);
            }else {
                int diff2 = matrix[top][mid+1] - target;
                if (diff2 ==0){
                    return true;
                }else if (diff2 > 0){
                    return false;
                }else {
                    return searchMatrix(top, bottom, mid+1, right, matrix, target);
                }
            }
        }
    }
}
