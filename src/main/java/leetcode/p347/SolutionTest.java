package leetcode.p347;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test1(){
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 5};
        int[] ints = new Solution().topKFrequent(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
