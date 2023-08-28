package leetcode.p149;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int[][] input = {
                {1, 1},
                {2, 2},
                {3, 3}
        };
        int i = new Solution().maxPoints(input);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int[][] input = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int i = new Solution().maxPoints(input);
        Assert.assertEquals(4, i);
    }

}
