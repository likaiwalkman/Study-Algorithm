package leetcode.p153;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int min = new Solution().findMin(new int[]{3, 4, 5, 1, 2});
        Assert.assertEquals(1, min);
    }

    @Test
    public void test2(){
        int min = new Solution().findMin(new int[]{4,5,6,7,0,1,2});
        Assert.assertEquals(0, min);
    }

    @Test
    public void test3(){
        int min = new Solution().findMin(new int[]{11,13,15,17});
        Assert.assertEquals(11, min);
    }
}
