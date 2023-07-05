package leetcode.p172;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().trailingZeroes(3);
        Assert.assertEquals(0 ,i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().trailingZeroes(5);
        Assert.assertEquals(1 ,i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().trailingZeroes(6);
        Assert.assertEquals(1 ,i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().trailingZeroes(0);
        Assert.assertEquals(0 ,i);
    }
}
