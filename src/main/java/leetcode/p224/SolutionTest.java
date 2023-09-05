package leetcode.p224;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int i = new Solution().calculate("1 + 1");
        Assert.assertEquals(2, i);
    }

    @Test
    public void test2(){
        int i = new Solution().calculate(" 2-1 + 2 ");
        Assert.assertEquals(3, i);
    }

    @Test
    public void test3(){
        int i = new Solution().calculate("(1+(4+5+2)-3)+(6+8)");
        Assert.assertEquals(23, i);
    }
}
