package leetcode.p79;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean exist = new Solution().exist(chars, word);
        Assert.assertTrue(exist);
    }

    @org.junit.Test
    public void test2(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE1234";
        boolean exist = new Solution().exist(chars, word);
        Assert.assertFalse(exist);
    }

    @org.junit.Test
    public void test3(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = new Solution().exist(chars, word);
        Assert.assertFalse(exist);
    }

    @org.junit.Test
    public void test4(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean exist = new Solution().exist(chars, word);
        Assert.assertTrue(exist);
    }
}
