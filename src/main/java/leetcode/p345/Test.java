package leetcode.p345;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = new Solution().reverseVowels("hello");
        Assert.assertEquals("holle", s);
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().reverseVowels("leetcode");
        Assert.assertEquals("leotcede", s);
    }
}
