package leetcode.p463;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().islandPerimeter(new int[][]{{1}});
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().islandPerimeter(new int[][]{{1, 0}});
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().islandPerimeter(new int[][]{{1, 1}});
        Assert.assertEquals(6, i);
    }
}
