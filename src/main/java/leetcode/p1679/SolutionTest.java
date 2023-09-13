package leetcode.p1679;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1() {
        int i = new Solution().maxOperations(new int[]{1, 2, 3, 4}, 5);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2() {
        int i = new Solution().maxOperations(new int[]{3,1,3,4,3}, 6);
        Assert.assertEquals(1, i);
    }
}
