package leetcode.p334;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        boolean b = new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5});
        Assert.assertTrue(b);
    }

    @Test
    public void test2(){
        boolean b = new Solution().increasingTriplet(new int[]{5,4,3,2,1});
        Assert.assertFalse(b);
    }

    @Test
    public void test3(){
        boolean b = new Solution().increasingTriplet(new int[]{2,1,5,0,4,6});
        Assert.assertTrue(b);
    }

    @Test
    public void test4(){
        boolean b = new Solution().increasingTriplet(new int[]{2,1,5,0,3});
        Assert.assertFalse(b);
    }
}
