package leetcode.p728;

import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        List<Integer> integers = new Solution().selfDividingNumbers(1, 22);
        System.out.println(integers);
    }

    @org.junit.Test
    public void test2(){
        List<Integer> integers = new Solution().selfDividingNumbers(47, 85);
        System.out.println(integers);
    }
}
