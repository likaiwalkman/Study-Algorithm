package leetcode.p918;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1(){
        int[] ints = {-74, -95, 22, 30, -68, -62, -59, 4, -62, 35, -78, 80, -82, 54, -42, 81, 56, -15, 32, -19, 34, 93, 57, -100, -1, -87, 68, -26, 18, 86, -55, -19, -68, -99, -9, 47, 24, 94, 92, 97, 5, 67, 97, -71, 63, -57, -52, -14, -86, -78, -17, 92, -61, -83, -84, -10, 20, 13, -68, -47, 7, 28, 66, 89, -41, -17, -14, -46, -72, -91, 4, 52, -17, -59, -85, -46, -94, -23, -48, -3, -64, -37, 2, 26, 76, 88, -8, -46, -19, -68, -9, -42, 86, -63, -22, -30, 100, -92, -42, 62};
        int i = new Solution().maxSubarraySumCircular(ints);
        System.out.println(i);
    }

    @Test
    public void test2(){
        int[] ints = {2,-2,2,7,8,0};
        int i = new Solution().maxSubarraySumCircular(ints);
        Assert.assertEquals(19 ,i);
        System.out.println(i);
    }
}
