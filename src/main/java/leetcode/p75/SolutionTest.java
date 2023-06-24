package leetcode.p75;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int[] arr = new int[]{2,0,2,1,1,0};
        new Solution().sortColors(arr);
        System.out.println(arr);
    }

    @Test
    public void test2(){
        int[] arr = new int[]{2,0,1};
        new Solution().sortColors(arr);
        System.out.println(arr);
    }

    @Test
    public void test3(){
        int[] arr = new int[]{0};
        new Solution().sortColors(arr);
        Assert.assertEquals(1, arr.length);
        Assert.assertEquals(0, arr[0]);
    }

    @Test
    public void test4(){
        int[] arr = new int[]{1};
        new Solution().sortColors(arr);
        Assert.assertEquals(1, arr.length);
        Assert.assertEquals(1, arr[0]);
    }

    @Test
    public void test5(){
        int[] arr = new int[]{2};
        new Solution().sortColors(arr);
        Assert.assertEquals(1, arr.length);
        Assert.assertEquals(2, arr[0]);
    }

    @Test
    public void test6(){
        int[] arr = new int[]{0,1};
        new Solution().sortColors(arr);
        Assert.assertEquals(2, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
    }

    @Test
    public void test7(){
        int[] arr = new int[]{0,2};
        new Solution().sortColors(arr);
        Assert.assertEquals(2, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(2, arr[1]);
    }

    @Test
    public void test8(){
        int[] arr = new int[]{1,2};
        new Solution().sortColors(arr);
        Assert.assertEquals(2, arr.length);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(2, arr[1]);
    }

    @Test
    public void test9(){
        int[] arr = new int[]{0,1,2};
        new Solution().sortColors(arr);
        Assert.assertEquals(3, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
        Assert.assertEquals(2, arr[2]);
    }

    @Test
    public void test10(){
        int[] arr = new int[]{1,0,2};
        new Solution().sortColors(arr);
        Assert.assertEquals(3, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
        Assert.assertEquals(2, arr[2]);
    }

    @Test
    public void test11(){
        int[] arr = new int[]{2, 1, 0};
        new Solution().sortColors(arr);
        Assert.assertEquals(3, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
        Assert.assertEquals(2, arr[2]);
    }

    @Test
    public void test12(){
        int[] arr = new int[]{2, 1, 0};
        new Solution().sortColors(arr);
        Assert.assertEquals(3, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
        Assert.assertEquals(2, arr[2]);
    }

    @Test
    public void test13(){
        int[] arr = new int[]{0, 1, 0};
        new Solution().sortColors(arr);
        Assert.assertEquals(3, arr.length);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(0, arr[1]);
        Assert.assertEquals(1, arr[2]);
    }
}
