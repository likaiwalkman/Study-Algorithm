package leetcode.p90;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<List<Integer>> lists = new Solution().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }

    @org.junit.Test
    public void test2(){
        List<List<Integer>> lists = new Solution().subsetsWithDup(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}
