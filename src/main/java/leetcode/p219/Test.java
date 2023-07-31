package leetcode.p219;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        boolean b = new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        Assert.assertTrue(b);
    }

    @org.junit.Test
    public void test2(){
        boolean b = new Solution().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
        Assert.assertTrue(b);
    }
}
