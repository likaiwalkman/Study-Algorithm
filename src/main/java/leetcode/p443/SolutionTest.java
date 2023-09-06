package leetcode.p443;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compress = new Solution().compress(chars);
        Assert.assertEquals(6, compress);
    }
    
    @org.junit.Test
    public void test2(){
        char[] chars = {'a'};
        int compress = new Solution().compress(chars);
        Assert.assertEquals(1, compress);
    }
    
    @org.junit.Test
    public void test3(){
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int compress = new Solution().compress(chars);
        Assert.assertEquals(4, compress);
    }
}
