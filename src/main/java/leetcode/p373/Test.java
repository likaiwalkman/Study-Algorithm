package leetcode.p373;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test1(){
        List<List<Integer>> lists = new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(lists);
    }

    @org.junit.Test
    public void test2(){
        List<List<Integer>> lists = new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        System.out.println(lists);
    }
    @org.junit.Test
    public void test3(){
        List<List<Integer>> lists = new Solution().kSmallestPairs(new int[]{-10,-4,0,0,6,6,6,7,10,22,100}, new int[]{3,5,6,7,8,100}, 20);
        System.out.println(lists);
    }
}
