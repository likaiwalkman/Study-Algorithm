package leetcode.p2765;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test01() {
        int[] nums1 = {2,3,4,3,4};
        long l = new Solution().alternatingSubarray(nums1);
        Assert.assertEquals(4, l);
    }

    @Test
    public void test02() {
        int[] nums1 = {21, 9, 5};
        long l = new Solution().alternatingSubarray(nums1);
        Assert.assertEquals(-1, l);
    }
    @Test
    public void test03() {
        int[] nums1 = {14,30,29,49,3,23,44,21,26,52};
        long l = new Solution().alternatingSubarray(nums1);
        Assert.assertEquals(-1, l);
    }
}
