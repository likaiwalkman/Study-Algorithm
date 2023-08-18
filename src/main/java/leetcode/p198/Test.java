package leetcode.p198;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int rob = new Solution().rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, rob);
    }

    @org.junit.Test
    public void test2(){
        int rob = new Solution().rob(new int[]{2,7,9,3,1});
        Assert.assertEquals(12, rob);
    }

    @org.junit.Test
    public void test3(){
        int rob = new Solution().rob(new int[]{2,1,1,2});
        Assert.assertEquals(4, rob);
    }
}
