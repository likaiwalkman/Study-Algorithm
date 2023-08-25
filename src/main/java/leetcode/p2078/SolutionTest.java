package leetcode.p2078;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int i = new Solution().maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1});
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().maxDistance(new int[]{1,8,3,8,3});
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().maxDistance(new int[]{0,1});
        Assert.assertEquals(1, i);
    }
}
