package leetcode.p394;

import org.junit.Assert;

public class SolutionTest {

    @org.junit.Test
    public void test1(){
        String s = new Solution().decodeString("3[a]2[bc]");
        Assert.assertEquals("aaabcbc", s);
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().decodeString("3[a2[c]]");
        Assert.assertEquals("accaccacc", s);
    }

    @org.junit.Test
    public void test3(){
        String s = new Solution().decodeString("abc3[cd]xyz");
        Assert.assertEquals("abccdcdcdxyz", s);
    }

}
