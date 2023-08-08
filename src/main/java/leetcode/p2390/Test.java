package leetcode.p2390;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test1(){
        String s = new Solution().removeStars("erase*****");
        Assert.assertEquals("", s);
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().removeStars("leet**cod*e");
        Assert.assertEquals("lecoe", s);
    }
}
