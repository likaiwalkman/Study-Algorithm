package leetcode.p502;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(4, maximizedCapital);
    }

    @org.junit.Test
    public void test2(){
        int k = 3, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,2};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(6, maximizedCapital);
    }

    @org.junit.Test
    public void test3(){
        int k = 1, w = 2;
        int[] profits = {1,2,3}, capital = {1, 1, 2};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(5, maximizedCapital);
    }
}
