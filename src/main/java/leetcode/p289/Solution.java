package leetcode.p289;

public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] assistant = new int[board.length][];
        for (int i = 0; i < assistant.length; i++) {
            assistant[i] = new int[board[0].length];
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0){
                    continue;
                }

                if (i-1 >= 0) {
                    if (j-1 >= 0){
                        assistant[i-1][j-1]++;
                    }
                    assistant[i-1][j]++;
                    if (j+1 < board[i].length) {
                        assistant[i-1][j+1]++;
                    }
                }

                if (j-1 >=0){
                    assistant[i][j-1]++;
                }
                if (j+1 < board[i].length){
                    assistant[i][j+1]++;
                }

                if (i+1 < board.length){
                    if (j-1 >=0){
                        assistant[i+1][j-1]++;
                    }
                    assistant[i+1][j]++;
                    if (j+1 < board[i].length){
                        assistant[i+1][j+1]++;
                    }
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && (assistant[i][j] < 2 || assistant[i][j] > 3)) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 0 && assistant[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
