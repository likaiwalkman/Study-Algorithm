package leetcode.p2215;

import leetcode.p2215.Solution;
import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test2(){
        List<List<Integer>> difference = new Solution().findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
        System.out.println(difference);
    }
}
