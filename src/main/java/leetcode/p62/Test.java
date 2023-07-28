package leetcode.p62;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().uniquePaths(3, 2);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().uniquePaths(2, 3);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().uniquePaths(3, 7);
        Assert.assertEquals(28, i);
    }

    @org.junit.Test
    public void test4(){
        int i = new Solution().uniquePaths(1, 1);
        Assert.assertEquals(1, i);
    }
}
