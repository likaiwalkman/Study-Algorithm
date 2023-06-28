package leetcode.p1486;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        Assert.assertEquals(8, new Solution().xorOperation(5,0));
    }

    @org.junit.Test
    public void test2(){
        Assert.assertEquals(8, new Solution().xorOperation(4,3));
    }
}
