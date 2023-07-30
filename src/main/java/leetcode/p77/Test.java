package leetcode.p77;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }

    @org.junit.Test
    public void test2(){
        List<List<Integer>> combine = new Solution().combine(1, 1);
        System.out.println(combine);
    }
}
