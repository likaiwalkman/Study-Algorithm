package com.ctrip.langs.backtrace;

/**
 * Created by kai_li on 2016/1/25.
 * Limitation: could not search with rolling up or leftwards
 */
public class FindCheese {

    static boolean flag;
    static int SIZE = 8;

    public static void backtrace(int i, int j, int[][] PuzzleMatrix, boolean l, boolean r, boolean u, boolean d){
        if ( PuzzleMatrix[i][j] == 0 ){
            return ;
        }
        if (PuzzleMatrix[i][j] == 9){
            flag = true;
            return;
        }
        if ( i > 0 && !d) {
            backtrace(i-1, j, PuzzleMatrix, false, false, true, false);
        }
        if ( j > 0 && !r) {
            backtrace(i, j-1, PuzzleMatrix, false, true, false,false);
        }
        if ( i < SIZE-1 && !u ) {
            backtrace(i+1, j, PuzzleMatrix, false,false,false,true);
        }
        if ( j < SIZE-1 && !d ) {
            backtrace(i, j+1, PuzzleMatrix, true,false,false,false );
        }
    }

    public static void main(String[] args) {
        int[][] PuzzleMatrix = {
                {1,0,1,1,1,0,0,1},
                {1,0,0,0,1,1,1,1},
                {1,0,0,0,0,0,0,0},
                {1,0,1,0,9,0,1,1},
                {1,1,1,0,1,0,0,1},
                {1,0,1,0,1,1,0,1},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,1}
        };
        backtrace(0,0,PuzzleMatrix, false,false,false,false);
        System.out.println(flag);
    }
}
