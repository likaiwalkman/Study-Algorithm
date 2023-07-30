package leetcode.p79;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertTrue(exist);
    }

    @org.junit.Test
    public void test2(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE1234";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertFalse(exist);
    }

    @org.junit.Test
    public void test3(){
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertFalse(exist);
    }

    @org.junit.Test
    public void test4(){
        char[][] chars = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertTrue(exist);
    }

    @org.junit.Test
    public void test5(){
        char[][] chars = {{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'}};
        String word = "AAAAAAAAAAAAAAa";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertFalse(exist);
    }

    @org.junit.Test
    public void test6(){
        char[][] chars = {{'A'}};
        String word = "A";
        boolean exist = new SolutionRefactor().exist(chars, word);
        Assert.assertTrue(exist);
    }
}
