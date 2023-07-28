package leetcode.p40;

import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] a = new int[]{10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("-------------");

        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    @org.junit.Test
    public void test2(){

        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(lists);
    }

    @org.junit.Test
    public void test3(){

        List<List<Integer>> lists = new PureSolution().combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
        System.out.println(lists);
    }
}
