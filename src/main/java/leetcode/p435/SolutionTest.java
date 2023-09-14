package leetcode.p435;

import org.junit.Assert;

public class SolutionTest {

    @org.junit.Test
    public void test1(){
        int i = new Solution().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}});
        Assert.assertEquals(0, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}});
        Assert.assertEquals(7, i);
    }


}
