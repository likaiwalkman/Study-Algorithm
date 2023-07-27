package leetcode.p58;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().lengthOfLastWord("Hello World");
        Assert.assertEquals(5, i);
    }
    @org.junit.Test
    public void test2(){
        int i = new Solution().lengthOfLastWord("   fly me   to   the moon  ");
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test3(){
        int i = new Solution().lengthOfLastWord("luffy is still joyboy");
        Assert.assertEquals(6, i);
    }
}
