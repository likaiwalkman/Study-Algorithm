package leetcode.p53;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test01(){
        int i = new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assert.assertEquals(6, i);
    }
}
