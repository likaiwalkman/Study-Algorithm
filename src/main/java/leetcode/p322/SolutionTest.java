package leetcode.p322;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int i = new Solution().coinChange(new int[]{1, 2, 5}, 11);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test2() {
        int i = new Solution().coinChange(new int[]{2}, 3);
        Assert.assertEquals(-1, i);
    }

    @Test
    public void test3() {
        int i = new Solution().coinChange(new int[]{1}, 0);
        Assert.assertEquals(0, i);
    }
}
