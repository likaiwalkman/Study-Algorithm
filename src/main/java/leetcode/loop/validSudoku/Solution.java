package leetcode.loop.validSudoku;

import java.util.HashSet;
import java.util.Set;
/*
* The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
* */
/**
 * Created by kai_li on 2016/2/1.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //horizontal and vertical validation
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        for(int i=0;i < 9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    if(set1.contains(board[i][j])){
                        return false;
                    }
                    set1.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if(set2.contains(board[j][i])){
                        return false;
                    }
                    set2.add(board[j][i]);
                }
            }
            set1.clear();
            set2.clear();
        }
        //sub-box validation
        Set<Character> set3 = new HashSet<Character>();
        for (int k = 0; k < 9; k++) {
            for (int i = 3 * (k / 3); i < 3 * (k / 3)+3; i++) {
                for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
                    if(board[i][j] != '.'){
                        if(set3.contains(board[i][j])){
                            return false;
                        }
                        set3.add(board[i][j]);
                    }
                }
            }
            set3.clear();
        }
        return true;
    }
}