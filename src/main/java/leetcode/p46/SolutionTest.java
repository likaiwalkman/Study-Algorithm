package leetcode.p46;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test01(){
        List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    @Test
    public void test02(){
        List<List<Integer>> permute = new Solution().permute(new int[]{1});
        System.out.println(permute);
    }

    @Test
    public void test03(){
        List<List<Integer>> permute = new Solution().permute(new int[]{0,1});
        System.out.println(permute);
    }
}
