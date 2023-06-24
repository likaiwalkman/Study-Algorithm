package leetcode.p39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1(){
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            l1.add(i);
            l2.add(i);
        }

        System.out.println(l1.equals(l2));
    }

    @Test
    public void test2(){
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }

    @Test
    public void test3(){
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{5,10,8,4,3,12,9}, 27);
        System.out.println(lists);
    }

    @Test
    public void test4(){
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(lists);
    }
}
