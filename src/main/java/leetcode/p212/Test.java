package leetcode.p212;

import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.insert("bag");
        wordDictionary.insert("bags");

        Assert.assertTrue(wordDictionary.search("bag"));
        Assert.assertTrue(wordDictionary.search("bags"));
        Assert.assertFalse(wordDictionary.search("cat"));

        Assert.assertTrue(wordDictionary.startsWith("bag"));
        Assert.assertTrue(wordDictionary.startsWith("bags"));
        Assert.assertFalse(wordDictionary.startsWith("cat"));
    }

    @org.junit.Test
    public void test2(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.insert("bag");
        wordDictionary.insert("bags");
        wordDictionary.deleteWord("bags");

        Assert.assertTrue(wordDictionary.search("bag"));
        Assert.assertFalse(wordDictionary.search("bags"));
        Assert.assertFalse(wordDictionary.search("cat"));

        Assert.assertTrue(wordDictionary.startsWith("bag"));
        Assert.assertFalse(wordDictionary.startsWith("bags"));
        Assert.assertFalse(wordDictionary.startsWith("cat"));
    }

    @org.junit.Test
    public void test3(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.insert("bag");
        wordDictionary.insert("bags");
        wordDictionary.deleteWord("bag");

        Assert.assertTrue(wordDictionary.search("bags"));
        Assert.assertFalse(wordDictionary.search("bag"));
        Assert.assertFalse(wordDictionary.search("cat"));

        Assert.assertTrue(wordDictionary.startsWith("bags"));
        Assert.assertTrue(wordDictionary.startsWith("bag"));
        Assert.assertFalse(wordDictionary.startsWith("cat"));
    }

    @org.junit.Test
    public void test4(){
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> words1 =
                new Solution().findWords(board, words);
        System.out.println(words1);
    }

    @org.junit.Test
    public void test5(){
        char[][] board = {{'a','b'},{'c','d'}};
        String[] words = {"abcb"};
        List<String> words1 =
                new Solution().findWords(board, words);
        System.out.println(words1);
    }
}
