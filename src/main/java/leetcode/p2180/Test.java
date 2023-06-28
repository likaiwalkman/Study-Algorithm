package leetcode.p2180;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        Assert.assertEquals(2, new Solution().countEven(4));
    }

    @org.junit.Test
    public void test2(){
        Assert.assertEquals(14, new Solution().countEven(30));
    }
}
