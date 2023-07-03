package leetcode.p7;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int reverse = new Solution().reverse(123);
        Assert.assertEquals(321, reverse);
    }

    @org.junit.Test
    public void test2(){
        System.out.println(Integer.MAX_VALUE);
        int reverse = new Solution().reverse(2147483647);
        Assert.assertEquals(0, reverse);
    }

    @org.junit.Test
    public void test3(){
        System.out.println(Integer.MIN_VALUE);
        int reverse = new Solution().reverse(-2147483648);
        Assert.assertEquals(0, reverse);
    }
}
