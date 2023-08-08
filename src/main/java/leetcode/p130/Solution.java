package leetcode.p130;

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O'){
                mark(board, 0, i, m, n, 'O', 'Z');
            }
            if (board[m-1][i] == 'O'){
                mark(board, m-1, i, m, n, 'O', 'Z');
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                mark(board, i, 0, m, n, 'O', 'Z');
            }
            if (board[i][n-1] == 'O'){
                mark(board, i, n-1, m, n, 'O', 'Z');
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int i, int j, int m, int n, char oldVal, char newVal){
        if (board[i][j] != oldVal) {
            return;
        }
        board[i][j] = newVal;

        if (i-1 >=0 && board[i-1][j] == oldVal){
            mark(board, i-1, j, m, n, oldVal, newVal);
        }
        if (j-1 >=0 && board[i][j-1] == oldVal){
            mark(board, i, j-1, m, n, oldVal, newVal);
        }
        if (i+1 < m && board[i+1][j] == oldVal){
            mark(board, i+1, j, m, n, oldVal, newVal);
        }
        if (j+1 < n && board[i][j+1] == oldVal){
            mark(board, i, j+1, m, n, oldVal, newVal);
        }
    }
}
