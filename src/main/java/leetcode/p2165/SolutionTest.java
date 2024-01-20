package leetcode.p2165;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        long l = new Solution().smallestNumber(310);
        Assert.assertEquals(103L, l);
    }

    @org.junit.Test
    public void test2(){
        long l = new Solution().smallestNumber(-7605);
        Assert.assertEquals(-7650L, l);
    }
}
