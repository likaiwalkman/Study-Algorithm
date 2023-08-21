package leetcode.p427;

public class Solution {

    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length-1, 0, grid.length-1);
    }

    Node construct(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd){
        int v = grid[rowStart][colStart];
        boolean allSame = true;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] != v) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                break;
            }
        }
        if (allSame){
            return new Node(v == 1, true);
        }

        Node root = new Node(v == 1, false);

        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;

        root.topLeft = construct(grid, rowStart, rowMid, colStart, colMid);
        root.topRight = construct(grid, rowStart, rowMid, colMid+1, colEnd);
        root.bottomLeft = construct(grid, rowMid+1, rowEnd, colStart, colMid);
        root.bottomRight = construct(grid, rowMid+1, rowEnd, colMid+1, colEnd);

        return root;
    }
}