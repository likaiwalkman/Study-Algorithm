package leetcode.p1456;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1(){
        int i = new Solution().maxVowels("abciiidef", 3);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test2(){
        int i = new Solution().maxVowels("aeiou", 2);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test3(){
        int i = new Solution().maxVowels("leetcode", 3);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test4(){
        int i = new Solution().maxVowels("rhythms", 4);
        Assert.assertEquals(0, i);
    }

    @Test
    public void test5(){
        int i = new Solution().maxVowels("tryhard", 4);
        Assert.assertEquals(1, i);
    }

    @Test
    public void test6(){
        int i = new Solution().maxVowels("novowels", 1);
        Assert.assertEquals(1, i);
    }


}
