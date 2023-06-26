package leetcode.p45;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int minJump = new Solution().jump(new int[]{2, 3, 0, 1, 4});
        Assert.assertEquals(2, minJump);
    }

    @Test
    public void test2(){
        int minJump = new Solution().jump(new int[]{2,3,1,1,4});
        Assert.assertEquals(2, minJump);
    }

    @Test
    public void test3(){
        int minJump = new Solution().jump(new int[]{0});
        Assert.assertEquals(0, minJump);
    }

    @Test
    public void test4(){
        int minJump = new Solution().jump(new int[]{1,2});
        Assert.assertEquals(1, minJump);
    }

    @Test
    public void test5(){
        int minJump = new Solution().jump(new int[]{1, 2, 3});
        Assert.assertEquals(2, minJump);
    }

    @Test
    public void test6(){
        int minJump = new Solution().jump(new int[]{2,3,1,1,4});
        Assert.assertEquals(2, minJump);
    }
}
