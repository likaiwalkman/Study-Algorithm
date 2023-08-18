package leetcode.p433;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test1(){
        String start = "AAAAACCC", end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        int i = new Solution().minMutation(start, end, bank);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int i = new Solution().minMutation(start, end, bank);
        Assert.assertEquals(2, i);
    }


    @org.junit.Test
    public void test3(){
        String  start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int i = new Solution().minMutation(start, end, bank);
        Assert.assertEquals(1, i);
    }
}
