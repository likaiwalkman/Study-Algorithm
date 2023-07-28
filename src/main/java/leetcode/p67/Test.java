package leetcode.p67;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = new Solution().addBinary("11", "11");
        Assert.assertEquals("110", s);
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().addBinary("1", "11");
        Assert.assertEquals("100", s);
    }
}
