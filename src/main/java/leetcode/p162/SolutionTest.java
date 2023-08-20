package leetcode.p162;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int peakElement = new Solution().findPeakElement(new int[]{1, 2, 3, 1});
            System.out.println(peakElement);
    }

    @Test
    public void test2(){
        int peakElement = new Solution().findPeakElement(new int[]{1,2,1,3,5,6,4});
            System.out.println(peakElement);
    }
}
