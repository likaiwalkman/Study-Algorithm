package leetcode.p452;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] ints = {{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = new Solution().findMinArrowShots(ints);
        Assert.assertEquals(2, minArrowShots);
    }

    @org.junit.Test
    public void test2(){
        int[][] ints = {{1,2},{3,4},{5,6},{7,8}};
        int minArrowShots = new Solution().findMinArrowShots(ints);
        Assert.assertEquals(4, minArrowShots);
    }

    @org.junit.Test
    public void tes3(){
        int[][] ints = {{1,2},{2,3},{3,4},{4,5}};
        int minArrowShots = new Solution().findMinArrowShots(ints);
        Assert.assertEquals(2, minArrowShots);
    }

    @org.junit.Test
    public void tes4(){
        int[][] ints = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int minArrowShots = new Solution().findMinArrowShots(ints);
        Assert.assertEquals(2, minArrowShots);
    }

    @org.junit.Test
    public void tes5(){
        int[][] ints = {{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}};
        int minArrowShots = new Solution().findMinArrowShots(ints);
        Assert.assertEquals(3, minArrowShots);
    }
}
