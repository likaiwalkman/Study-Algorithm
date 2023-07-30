package leetcode.p81;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        boolean f = new leetcode.p81.Solution().search(new int[]{2,5,6,0,0,1,2}, 0);
        Assert.assertTrue(f);
    }

    @org.junit.Test
    public void test2(){
        boolean f = new leetcode.p81.Solution().search(new int[]{2,5,6,0,0,1,2}, 3);
        Assert.assertFalse(f);
    }

    @org.junit.Test
    public void test3(){
        boolean f = new leetcode.p81.Solution().search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
        Assert.assertTrue(f);
    }

    @org.junit.Test
    public void test4(){
        boolean f = new leetcode.p81.Solution().search(new int[]{1,1,1,1,3,1},3);
        Assert.assertTrue(f);
    }
    @org.junit.Test
    public void test5(){
        boolean f = new leetcode.p81.Solution().search(new int[]{3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3},2);
        Assert.assertTrue(f);
    }
}
