package leetcode.p643;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        double v = new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        double e = 12.75;
        Assert.assertEquals(e, v, 0);
    }

    @org.junit.Test
    public void test2(){
        double v = new Solution().findMaxAverage(new int[]{5}, 1);
        double e = 5.0;
        Assert.assertEquals(e, v, 0);
    }
}
