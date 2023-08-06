package leetcode.p167;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test(){
        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertEquals(1, ints[0]);
        Assert.assertEquals(2, ints[1]);
    }

    @org.junit.Test
    public void test2(){
        int[] ints = new Solution().twoSum(new int[]{2, 3, 4}, 6);
        Assert.assertEquals(1, ints[0]);
        Assert.assertEquals(3, ints[1]);
    }
}
