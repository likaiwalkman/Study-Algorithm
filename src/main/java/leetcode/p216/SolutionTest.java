package leetcode.p216;

import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        List<List<Integer>> lists = new Solution().combinationSum3(3, 7);
        System.out.println(lists);
    }

    @org.junit.Test
    public void test2(){
        List<List<Integer>> lists = new Solution().combinationSum3(3, 9);
        System.out.println(lists);
    }

    @org.junit.Test
    public void test3(){
        List<List<Integer>> lists = new Solution().combinationSum3(4, 1);
        System.out.println(lists);
    }
}
