package leetcode.p1143;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() throws Exception{
        String text1 = "abcde", text2 = "ace";
        int lcs = new Solution().longestCommonSubsequence(text1, text2);
        Assert.assertEquals(3, lcs);
    }

    @org.junit.Test
    public void test2() throws Exception{
        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        int lcs = new TunedSolution().longestCommonSubsequence(text1, text2);
        Assert.assertEquals(1, lcs);
    }
}
