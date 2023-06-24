package leetcode.p78;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test1(){
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
        Assert.assertEquals(8, subsets.size());
    }

    @Test
    public void test2(){
        List<List<Integer>> subsets = new Solution().subsets(new int[]{0});
        System.out.println(subsets);
        Assert.assertEquals(2, subsets.size());
    }
}
