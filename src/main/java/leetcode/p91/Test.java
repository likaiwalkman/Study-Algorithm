package leetcode.p91;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().numDecodings("12");
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().numDecodings("226");
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().numDecodings("06");
        Assert.assertEquals(0, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().numDecodings("11106");
        Assert.assertEquals(2, i);
    }
}
