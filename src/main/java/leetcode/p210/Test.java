package leetcode.p210;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() throws Exception{
        int i = new Solution().rangeBitwiseAnd(5, 7);
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test2() throws Exception{
        int i = new Solution().rangeBitwiseAnd(0, 0);
        Assert.assertEquals(0, i);
    }

    @org.junit.Test
    public void test3() throws Exception{
        int i = new Solution().rangeBitwiseAnd(1, 2147483647);
        Assert.assertEquals(0, i);
    }

    @org.junit.Test
    public void test4() throws Exception{
        int i = new Solution().rangeBitwiseAnd(600000000, 2147483645);
        Assert.assertEquals(0, i);
    }
}
