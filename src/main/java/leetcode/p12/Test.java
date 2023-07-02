package leetcode.p12;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() {
        String s = new Solution().intToRoman(140);
        Assert.assertEquals("CXL", s);
    }

    @org.junit.Test
    public void test2() {
        String s = new Solution().intToRoman(3);
        Assert.assertEquals("III", s);
    }

    @org.junit.Test
    public void test3() {
        String s = new Solution().intToRoman(4);
        Assert.assertEquals("IV", s);
    }

    @org.junit.Test
    public void test4() {
        String s = new Solution().intToRoman(9);
        Assert.assertEquals("IX", s);
    }

    @org.junit.Test
    public void test5() {
        String s = new Solution().intToRoman(58);
        Assert.assertEquals("LVIII", s);
    }

    @org.junit.Test
    public void test6() {
        String s = new Solution().intToRoman(1994);
        Assert.assertEquals("MCMXCIV", s);
    }
}
