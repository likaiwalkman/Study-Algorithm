package leetcode.p2596;

public class Solution {
    class Index {
        int[] pos;
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] !=0){
            return false;
        }

        if (grid.length == 1) {
            return true;
        }

        int dimension = grid.length;
        int cellCount = dimension * dimension;
        Index[] indices = new Index[cellCount];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Index index = new Index();
                index.pos = new int[]{i, j};
                indices[grid[i][j]] = index;
            }
        }


        int[] prev = indices[0].pos;
        for (int i = 1; i < indices.length; i++) {
            int[] current = indices[i].pos;
            int xDiff = current[0] - prev[0];
            int yDiff = current[1] - prev[1];

            xDiff = xDiff < 0 ? 0-xDiff : xDiff;
            yDiff = yDiff < 0 ? 0-yDiff : yDiff;

            boolean caseOne = xDiff == 2 && yDiff == 1;
            boolean caseTwo = xDiff == 1 && yDiff == 2;
            if (!caseOne && !caseTwo){
                return false;
            }

            prev = current;
        }
        return true;
    }
}
