package leetcode.p1318;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().minFlips(2, 6, 5);
        Assert.assertEquals(3, i);
    }
}
