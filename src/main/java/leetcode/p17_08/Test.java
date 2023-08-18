package leetcode.p17_08;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] height = new int[]{1,2,3,4};
        int[] weight = new int[]{4,3,2,1};
        int i = new Solution().bestSeqAtIndex(height, weight);
        Assert.assertEquals(1, i);
    }
}
