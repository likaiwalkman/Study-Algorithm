package leetcode.p55;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1(){
        boolean b = new Solution().canJump(new int[]{2, 3, 1, 1, 4});
        Assert.assertTrue(b);
    }

    @Test
    public void test2(){
        boolean b = new Solution().canJump(new int[]{3,2,1,0,4});
        Assert.assertFalse(b);
    }

    @Test
    public void test3(){
        boolean b = new Solution().canJump(new int[]{0});
        Assert.assertTrue(b);
    }

    @Test
    public void test4(){
        boolean b = new Solution().canJump(new int[]{0, 1});
        Assert.assertFalse(b);
    }
}
