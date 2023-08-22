package leetcode.p53;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test01(){
        int i = new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assert.assertEquals(6, i);
    }
    @org.junit.Test
    public void test02(){
        int i = new Solution().maxSubArray(new int[]{-29,12,4,-8,15,11,-12,-16,-9,19,-12,22,16,-9,14,24,-14,12,18,-18,-10,-10,-23,-2,-23,11,12,18,-9,9});
        Assert.assertEquals(99, i);
    }
}
