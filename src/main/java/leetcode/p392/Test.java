package leetcode.p392;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = "abc", t = "ahbgdc";
        boolean subsequence = new Solution().isSubsequence(s, t);
        Assert.assertTrue(subsequence);
    }

    @org.junit.Test
    public void test2(){
        String s = "axc", t = "ahbgdc";
        boolean subsequence = new Solution().isSubsequence(s, t);
        Assert.assertFalse(subsequence);
    }
}
