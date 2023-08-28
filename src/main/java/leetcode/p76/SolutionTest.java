package leetcode.p76;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");
        Assert.assertEquals("BANC", s);
    }

    @Test
    public void test2(){
        String s = new Solution().minWindow("babb", "baba");
        Assert.assertEquals("", s);
    }
    @Test
    public void test3(){
        String s = new Solution().minWindow("baAaABabBba", "AbbB");
        Assert.assertEquals("ABabBb", s);
    }
}
