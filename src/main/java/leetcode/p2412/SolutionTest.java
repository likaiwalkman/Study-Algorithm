package leetcode.p2412;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test01() {
        long l = new Solution().minimumMoney(new int[][]{
                {2, 1},
                {5, 0},
                {4, 2}
        });
        Assert.assertEquals(10, l);
    }

    @Test
    public void test02() {
        long l = new Solution().minimumMoney(new int[][]{
                {3, 0},
                {0, 3}
        });
        Assert.assertEquals(3, l);
    }

    @Test
    public void test03() {
        long l = new Solution().minimumMoney(new int[][]{
                {6, 5},
                {0, 5},
                {8, 5},
                {3, 6},
                {9, 0},
                {10, 1},
                {4, 10}
        });
        Assert.assertEquals(27, l);
    }
}
