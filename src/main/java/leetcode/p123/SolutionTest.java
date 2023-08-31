package leetcode.p123;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int i = new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        Assert.assertEquals(6, i);
    }

    @Test
    public void test2(){
        int i = new Solution().maxProfit(new int[]{1,2,3,4,5});
        Assert.assertEquals(4, i);
    }

    @Test
    public void test3(){
        int i = new Solution().maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(0, i);
    }

    @Test
    public void test4(){
        int i = new Solution().maxProfit(new int[]{3});
        Assert.assertEquals(0, i);
    }

    @Test
    public void test5(){
        int i = new Solution().maxProfit(new int[]{1,2,3,4,2,1,4});
        Assert.assertEquals(6, i);
    }

    @Test
    public void test6(){
        int i = new Solution().maxProfit(new int[]{1,2,3,4,3,2,1,4,3});
        Assert.assertEquals(6, i);
    }

    @Test
    public void test7(){
        int i = new Solution().maxProfit(new int[]{1,4,2,3,1,4,1,7});
        Assert.assertEquals(9, i);
    }

    @Test
    public void test8(){
        int i = new Solution().maxProfit(new int[]{1,4,2,3,1,8,1,7});
        Assert.assertEquals(13, i);
    }

    @Test
    public void test9(){
        int i = new Solution().maxProfit(new int[]{6,5,4,8,6,8,7,8,9,4,5});
        Assert.assertEquals(13, i);
    }
}
