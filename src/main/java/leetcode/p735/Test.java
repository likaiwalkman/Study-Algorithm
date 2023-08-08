package leetcode.p735;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] ints = new Solution().asteroidCollision(new int[]{5, 10, -5});
        Assert.assertEquals(2 ,ints.length);
        Assert.assertEquals(5 ,ints[0]);
        Assert.assertEquals(10 ,ints[1]);
    }

    @org.junit.Test
    public void test2(){
        int[] ints = new Solution().asteroidCollision(new int[]{5, -5});
        Assert.assertEquals(0 ,ints.length);
    }

    @org.junit.Test
    public void test3(){
        int[] ints = new Solution().asteroidCollision(new int[]{-2,2,-1,-2});
        Assert.assertEquals(1 ,ints.length);
        Assert.assertEquals(-2 ,ints[0]);
    }
}
