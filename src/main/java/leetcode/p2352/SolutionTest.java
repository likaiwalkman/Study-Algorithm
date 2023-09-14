package leetcode.p2352;

import org.junit.Assert;

public class SolutionTest {

    @org.junit.Test
    public void test1(){
        int i = new Solution().equalPairs(new int[][]{
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        });
        Assert.assertEquals(1, i);
    }

}
