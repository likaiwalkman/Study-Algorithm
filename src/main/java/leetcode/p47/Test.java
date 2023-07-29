package leetcode.p47;

import org.junit.Assert;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test1(){
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists);
        Assert.assertEquals(6, lists.size());
    }

    @org.junit.Test
    public void test2(){
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1, 3});
        System.out.println(lists);
        Assert.assertEquals(3, lists.size());
    }
}
