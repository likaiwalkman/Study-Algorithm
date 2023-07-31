package leetcode.p202;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() throws Exception{
        boolean happy = new Solution().isHappy(19);
        Assert.assertTrue(happy);
    }

    @org.junit.Test
    public void test2() throws Exception{
        boolean happy = new Solution().isHappy(2);
        Assert.assertFalse(happy);
    }

    @org.junit.Test
    public void test3() throws Exception{
        boolean happy = new Solution().isHappy(Integer.MAX_VALUE);
        Assert.assertFalse(happy);
    }
}
