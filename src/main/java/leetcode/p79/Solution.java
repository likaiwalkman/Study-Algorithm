package leetcode.p79;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    class Ints{
        public Ints(int[] arr){
            this.arr = arr;
        }
        int[] arr;
        @Override
        public int hashCode() {
            return (arr[0]+""+arr[1]).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null){
                return false;
            }
            if (! (obj instanceof Ints)) {
                return false;
            }
            Ints target = (Ints) obj;
            return arr[0] == target.arr[0] && arr[1] == target.arr[1];
        }
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (word.length() > m * n) {
            return false;
        }

        Set<Ints> visitedSet = new HashSet<>();
        List<int[]> visitedList = new ArrayList<>();

        int[] start = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start[0] = i;
                start[1] = j;

                int res = iter(board, visitedSet, visitedList, 0, m, n, word, start);
                if (res == 1){
                    return true;
                }
            }
        }
        return false;
    }

    private int iter(char[][] board, Set<Ints> visitedSet, List<int[]> visitedList, int count, int m, int n, String word, int[] start){
        if (count == word.length()){
            return 1;
        }

        List<int[]> options = new ArrayList<>();
        if (visitedSet.size() == 0) {
            options.add(start);
        }else {
            int[] last = visitedList.get(visitedList.size() - 1);
            int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for (int[] delta : deltas) {
                int[] option = new int[]{delta[0] + last[0], delta[1] + last[1]};
                if (!visitedSet.contains(new Ints(option)) && 0 <= option[0] && option[0] < m && 0 <=option[1] && option[1] < n){
                    options.add(option);
                }
            }
        }
        options = options.stream().filter(index -> word.charAt(visitedList.size()) == board[index[0]][index[1]]).collect(Collectors.toList());
        System.out.println();

        for (int i = 0; i < options.size(); i++) {
            int[] option = options.get(i);
            visitedSet.add(new Ints(option));
            visitedList.add(option);
            count++;
            int res = iter(board, visitedSet, visitedList, count, m, n, word, start);
            if (res == 1){
                return 1;
            }else if(res == -1){
                System.out.println();
            }else {
                visitedSet.remove(new Ints(option));
                visitedList.remove(visitedList.size()-1);
                count--;
            }
        }
        return -1;
    }

    public String toStr(Collection<int[]> set){
        return set.stream().map(ints->"["+ints[0]+","+ints[1]+"]").collect(Collectors.toList()).toString();
    }

    public static String watch(char[][] board, List<int[]> visitedList){
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
