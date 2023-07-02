package leetcode.p11;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() {
        int i = new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(49, i);
    }
}
