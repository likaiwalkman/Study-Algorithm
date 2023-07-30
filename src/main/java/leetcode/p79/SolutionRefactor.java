package leetcode.p79;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionRefactor {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (word.length() > m * n) {
            return false;
        }

        int[][] visited = new int[board.length][];
        for (int i = 0; i < m; i++) {
            visited[i] = new int[n];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean iter = iter(board, visited, m, n, word, 0, i, j);
                if (iter) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean iter(char[][] board, int[][] visited, int m, int n, String word, int count, int i, int j){
        if (word.charAt(count) != board[i][j]){
            return false;
        }

        if (++count == word.length()){
            return true;
        }

        visited[i][j] = 1;
        int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] delta : deltas) {
            int[] option = new int[]{delta[0] + i, delta[1] + j};
            if ( 0 <= option[0] && option[0] < m && 0 <=option[1] && option[1] < n && visited[option[0]][option[1]] == 0){
                boolean res = iter(board, visited, m, n, word, count, option[0], option[1]);
                if (res) {
                    return true;
                }
            }
        }
        visited[i][j] = 0;
        return false;
    }

    public String toStr(Collection<int[]> set){
        return set.stream().map(ints->"["+ints[0]+","+ints[1]+"]").collect(Collectors.toList()).toString();
    }

    public static String watchTrace(char[][] board, List<int[]> visitedList){
        if (visitedList == null || visitedList.size() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < visitedList.size(); i++) {
            int[] ints = visitedList.get(i);
            builder.append(board[ints[0]][ints[1]]);
        }
        return builder.toString();
    }
}
