package leetcode.p96;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().numTrees(1);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().numTrees(2);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().numTrees(3);
        Assert.assertEquals(5, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().numTrees(6);
        Assert.assertEquals(132, i);
    }
}
