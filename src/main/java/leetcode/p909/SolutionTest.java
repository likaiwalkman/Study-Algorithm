package leetcode.p909;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int i = new Solution().snakesAndLadders(board);
        System.out.println(i);
    }

    @Test
    public void test2(){
        int[][] board = {{-1,-1}, {-1,3}};
        int i = new Solution().snakesAndLadders(board);
        System.out.println(i);
    }
}
