package leetcode.p695;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
       int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int i = new Solution().maxAreaOfIsland(grid);
        Assert.assertEquals(6, i);
    }


    @org.junit.Test
    public void test2(){
        int[][] grid = {{0,0,0,0,0}};
        int i = new Solution().maxAreaOfIsland(grid);
        Assert.assertEquals(0, i);
    }

}
