package leetcode.p43;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String multiply = new Solution().multiply("123", "111");
        Assert.assertEquals("13653", multiply);
    }

    @org.junit.Test
    public void test2(){
        String multiply = new Solution().multiply("2", "3");
        Assert.assertEquals("6", multiply);
    }

    @org.junit.Test
    public void test3(){
        String multiply = new Solution().multiply("12312133243435345345646461231213324343534534564646", "1231213324343534534564646");
        System.out.println(multiply);
    }
}
