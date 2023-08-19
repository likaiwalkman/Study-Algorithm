package leetcode.p97;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1(){
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean interleave = new Solution().isInterleave(s1, s2, s3);
        Assert.assertTrue(interleave);
    }
    @Test
    public void test2(){
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        boolean interleave = new Solution().isInterleave(s1, s2, s3);
        Assert.assertFalse(interleave);
    }

    @Test
    public void test3(){
        String s1 = "", s2 = "", s3 = "";
        boolean interleave = new Solution().isInterleave(s1, s2, s3);
        Assert.assertTrue(interleave);
    }

    @Test
    public void test4(){
        String s1 = "a", s2 = "", s3 = "c";
        boolean interleave = new Solution().isInterleave(s1, s2, s3);
        Assert.assertTrue(interleave);
    }

    @Test
    public void test5(){
        String
        s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc",
        s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb",
        s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
        boolean interleave = new Solution().isInterleave(s1, s2, s3);
        Assert.assertTrue(interleave);
    }
}
