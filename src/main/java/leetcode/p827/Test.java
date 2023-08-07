package leetcode.p827;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] ints = {{1, 0}, {0, 1}};
        int i = new Solution().largestIsland(ints);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int[][] ints = {{1, 1}, {0, 1}};
        int i = new Solution().largestIsland(ints);
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test3(){
        int[][] ints = {{0, 0}, {0, 0}};
        int i = new Solution().largestIsland(ints);
        Assert.assertEquals(1, i);
    }
}
