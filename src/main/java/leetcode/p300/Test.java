package leetcode.p300;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 1, 2, 1, 3});
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().lengthOfLIS(new int[]{0,1,0,3,2,3});
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        Assert.assertEquals(6, i);
    }
}
