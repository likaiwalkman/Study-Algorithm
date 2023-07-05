package leetcode.p1732;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().largestAltitude(new int[]{-5, 1, 5, 0, -7});
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().largestAltitude(new int[]{-4,-3,-2,-1,4,3,2});
        Assert.assertEquals(0, i);
    }
}
