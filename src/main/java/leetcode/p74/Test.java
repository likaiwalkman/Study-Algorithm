package leetcode.p74;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = new Solution().searchMatrix(matrix, 13);
        Assert.assertFalse(b);
    }

    @org.junit.Test
    public void test2(){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = new Solution().searchMatrix(matrix, 3);
        Assert.assertTrue(b);
    }

    @org.junit.Test
    public void test3(){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean b = new Solution().searchMatrix(matrix, 10);
        Assert.assertTrue(b);
    }
}
