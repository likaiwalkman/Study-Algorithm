package leetcode.p823;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int i = new Solution().numFactoredBinaryTrees(new int[]{2, 4});
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().numFactoredBinaryTrees(new int[]{2, 4, 5, 10});
        Assert.assertEquals(7, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().numFactoredBinaryTrees(new int[]{18,3,6,2});
        Assert.assertEquals(12, i);
    }
}
