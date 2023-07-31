package leetcode.p221;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = new Solution().maximalSquare(matrix);
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test2(){
        char[][] matrix = {
                {'1','1'},
                {'1','1'}
        };
        int i = new Solution().maximalSquare(matrix);
        Assert.assertEquals(4, i);
    }
}
