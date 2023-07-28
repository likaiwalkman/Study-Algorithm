package leetcode.p33;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int index = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(index);
        Assert.assertEquals(4, index);
    }

    @org.junit.Test
    public void test2(){
        int index = new Solution().search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println(index);
        Assert.assertEquals(-1, index);
    }

    @org.junit.Test
    public void test3(){
        int index = new Solution().search(new int[]{1}, 0);
        System.out.println(index);
        Assert.assertEquals(-1, index);
    }

    @org.junit.Test
    public void test4(){
        int index = new Solution().search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(index);
        Assert.assertEquals(4, index);
    }
}
