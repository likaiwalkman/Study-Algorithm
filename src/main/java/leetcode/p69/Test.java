package leetcode.p69;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().mySqrt(8);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().mySqrt(4);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().mySqrt(15);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().mySqrt(1);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test5(){
        int i = new Solution().mySqrt(2);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test6(){
        //x^2     : 2147395600
        //real    : 2147483647
        //(x+1)^2 : 2147488281
        int i = new Solution().mySqrt(Integer.MAX_VALUE);
        Assert.assertEquals(46340, i);
    }
}
