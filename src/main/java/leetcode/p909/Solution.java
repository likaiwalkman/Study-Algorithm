package leetcode.p909;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] visited = new int[n*n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        while (queue.size() > 0){
            int[] poll = queue.poll();
            int num = poll[0];
            int count = poll[1];

            for (int i = 1; i <= 6; i++) {
                int x = num + i;
                if (x > n*n) {
                    break;
                }

                int[] pos = pos(x, n);
                int newTarget = board[pos[0]][pos[1]];
                if(newTarget != -1){
                    x = newTarget;
                }
                if (x == n * n) {
                    return count+1;
                }
                if(visited[x] != 1){
                    visited[x] = 1;
                    queue.add(new int[]{x, count+1});
                }
            }
        }
        return -1;
    }

    private static int[] pos(int num, int n){
        int reverseRowIndex = (num-1) / n;
        int rowIndex = n-1 - reverseRowIndex;
        int colIndex = 0;
        if (reverseRowIndex % 2 == 0) {
            colIndex = (num-1) % n;
        }else {
            colIndex = (num-1) % n;
            colIndex = n-1-colIndex;
        }
        return new int[]{rowIndex, colIndex};
    }
}
