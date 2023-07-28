package leetcode.p63;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test1(){
        int[][] ints = {
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };
        int i = new Solution().uniquePathsWithObstacles(ints);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2(){
        int[][] ints = {
                new int[]{0, 1},
                new int[]{0, 0}
        };
        int i = new Solution().uniquePathsWithObstacles(ints);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test3(){
        int[][] ints = {
                new int[]{1},
        };
        int i = new Solution().uniquePathsWithObstacles(ints);
        Assert.assertEquals(0, i);
    }

}
