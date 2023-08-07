package leetcode.p200;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        char[][] chars = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int i = new Solution().numIslands(chars);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test2(){
        char[][] chars = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int i = new Solution().numIslands(chars);
        Assert.assertEquals(3, i);
    }
}
