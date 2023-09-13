package leetcode.p2542;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test01() {
        int[] nums1 = {1,3,3,2}, nums2 = {2,1,3,4};
        long l = new Solution().maxScore(nums1, nums2, 3);
        Assert.assertEquals(12, l);
    }
}
