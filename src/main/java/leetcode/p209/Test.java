package leetcode.p209;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().minSubArrayLen(4, new int[]{1, 4, 4});
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        Assert.assertEquals(0, i);
    }
}
