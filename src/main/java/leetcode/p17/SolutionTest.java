package leetcode.p17;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test(){
        List<String> strings = new Solution().letterCombinations("2");
        System.out.println(strings);
    }

    @Test
    public void test2(){
        List<String> strings = new Solution().letterCombinations("23");
        System.out.println(strings);
    }
}
