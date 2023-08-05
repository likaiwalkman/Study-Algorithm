package leetcode.p150;

import org.junit.Assert;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test1(){
        String[] array = (String[]) Arrays.<String>asList("2", "1", "+", "3", "*").toArray();
        int eval = new Solution().evalRPN(array);
        Assert.assertEquals(9, eval);
    }

    @org.junit.Test
    public void test2(){
        String[] array = (String[]) Arrays.<String>asList("4","13","5","/","+").toArray();
        int eval = new Solution().evalRPN(array);
        Assert.assertEquals(6, eval);
    }
    @org.junit.Test
    public void test3(){
        String[] array = (String[]) Arrays.<String>asList("10","6","9","3","+","-11","*","/","*","17","+","5","+").toArray();
        int eval = new Solution().evalRPN(array);
        Assert.assertEquals(22, eval);
    }
}
