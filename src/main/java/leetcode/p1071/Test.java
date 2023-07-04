package leetcode.p1071;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String str1 = "ABCABC", str2 = "ABC";
        String s = new Solution().gcdOfStrings(str1, str2);
        Assert.assertEquals("ABC", s);
    }

    @org.junit.Test
    public void test2(){
        String str1 = "ABABAB", str2 = "ABAB";
        String s = new Solution().gcdOfStrings(str1, str2);
        Assert.assertEquals("AB", s);
    }

    @org.junit.Test
    public void test3(){
        String str1 = "LEET", str2 = "CODE";
        String s = new Solution().gcdOfStrings(str1, str2);
        Assert.assertEquals("", s);
    }
}
