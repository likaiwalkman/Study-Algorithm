package leetcode.p605;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        boolean b = new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        Assert.assertTrue(b);
    }

    @org.junit.Test
    public void test2(){
        boolean b = new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 2);
        Assert.assertFalse(b);
    }

    @org.junit.Test
    public void test3(){
        boolean b = new Solution().canPlaceFlowers(new int[]{1, 0}, 1);
        Assert.assertFalse(b);
    }
}
