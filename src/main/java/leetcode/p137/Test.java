package leetcode.p137;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test01(){
        int i = new Solution().singleNumber(new int[]{2, 2, 3, 2});
        Assert.assertEquals(3, i);
    }
}
