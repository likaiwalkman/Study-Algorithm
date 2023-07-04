package leetcode.p1768;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String result = new Solution().mergeAlternately("abc", "123");
        Assert.assertEquals("a1b2c3", result);
    }

    @org.junit.Test
    public void test2(){
        String result = new Solution().mergeAlternately("ab", "1234");
        Assert.assertEquals("a1b234", result);
    }

    @org.junit.Test
    public void test3(){
        String result = new Solution().mergeAlternately("abcd", "12");
        Assert.assertEquals("a1b2cd", result);
    }
}
