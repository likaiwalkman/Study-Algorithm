package leetcode.p166;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String s = new Solution().fractionToDecimal(1, 3);
        Assert.assertEquals("0.(3)", s);
    }

    @Test
    public void test2(){
        String s = new Solution().fractionToDecimal(1, 12);
        Assert.assertEquals("0.08(3)", s);
    }

    @Test
    public void test3(){
        String s = new Solution().fractionToDecimal(21, 12);
        Assert.assertEquals("1.75", s);
    }

    @Test
    public void test4(){
        String s = new Solution().fractionToDecimal(21, 13);
        Assert.assertEquals("1.(615384)", s);
    }

    @Test
    public void test5(){
        String s = new Solution().fractionToDecimal(-21, 13);
        Assert.assertEquals("-1.(615384)", s);
    }

    @Test
    public void test6(){
        String s = new Solution().fractionToDecimal(-1, 5);
        Assert.assertEquals("-0.2", s);
    }

    @Test
    public void test7(){
        String s = new Solution().fractionToDecimal(-1, -2147483648);
        Assert.assertEquals("0.0000000004656612873077392578125", s);
    }

    @Test
    public void test8(){
        String s = new Solution().fractionToDecimal(-2147483648, -1);
        Assert.assertEquals("2147483648", s);
    }
}
