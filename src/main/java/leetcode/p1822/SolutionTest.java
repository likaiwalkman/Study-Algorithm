package leetcode.p1822;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int i = new Solution().arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1});
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().arraySign(new int[]{1,5,0,2,-3});
        Assert.assertEquals(0, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().arraySign(new int[]{-1,1,-1,1,-1});
        Assert.assertEquals(-1, i);
    }
}
