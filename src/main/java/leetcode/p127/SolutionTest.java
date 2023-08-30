package leetcode.p127;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1(){
        String beginWord = "hit", endWord = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(arr);
        int i = new Solution().ladderLength(beginWord, endWord, wordList);
        Assert.assertEquals(5, i);
    }

    @Test
    public void test2(){
        String beginWord = "hit", endWord = "cog";
        String[] arr = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(arr);
        int i = new Solution().ladderLength(beginWord, endWord, wordList);
        Assert.assertEquals(0, i);
    }
}
