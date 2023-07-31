package leetcode.p274;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().hIndex(new int[]{3, 0, 6, 1, 5});
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().hIndex(new int[]{1,3,1});
        Assert.assertEquals(1, i);
    }
}
