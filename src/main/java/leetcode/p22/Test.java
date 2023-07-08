package leetcode.p22;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }

    @org.junit.Test
    public void test2(){
        List<String> strings = new Solution().generateParenthesis(1);
        System.out.println(strings);
    }
}
