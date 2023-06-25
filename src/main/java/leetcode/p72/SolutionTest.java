package leetcode.p72;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String word1 = "horse", word2 = "ros";
        int i = new Solution().minDistance(word1, word2);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test2(){
        String word1 = "intention", word2 = "execution";
        int i = new Solution().minDistance(word1, word2);
        Assert.assertEquals(5, i);
    }
}
