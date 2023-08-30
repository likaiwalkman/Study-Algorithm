package leetcode.p1525;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1() {
        int i = new Solution().numSplits("aacaba");
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2() {
        int i = new Solution().numSplits("abcd");
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test3() {
        int i = new Solution().numSplits("aaaaa");
        Assert.assertEquals(4, i);
    }
}