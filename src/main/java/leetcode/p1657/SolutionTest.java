package leetcode.p1657;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1() {
        boolean b = new Solution().closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff");
        Assert.assertFalse(b);
    }
}
