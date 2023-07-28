package leetcode.p64;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] ints = {
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        };
        int i = new Solution().minPathSum(ints);
        Assert.assertEquals(7, i);
    }

    @org.junit.Test
    public void test2(){
        int[][] ints = {
                new int[]{1,4,8,6,2,2,1,7},
                new int[]{4,7,3,1,4,5,5,1},
                new int[]{8,8,2,1,1,8,0,1},
                new int[]{8,9,2,9,8,0,8,9},
                new int[]{5,7,5,7,1,8,5,5},
                new int[]{7,0,9,4,5,6,5,6},
                new int[]{4,9,9,7,9,1,9,0}
        };
        int i = new Solution().minPathSum(ints);
        Assert.assertEquals(47, i);
    }
}
