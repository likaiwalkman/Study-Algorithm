package leetcode.p211;

;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        WordDictionary wordDictionary =  new WordDictionary();
        wordDictionary.addWord("abcd");
        Assert.assertTrue(wordDictionary.search("abcd"));
        Assert.assertTrue(wordDictionary.search("abc."));
        Assert.assertTrue(wordDictionary.search(".bc."));
        Assert.assertTrue(wordDictionary.search("a.c."));
        Assert.assertFalse(wordDictionary.search("ac.."));
    }

    @org.junit.Test
    public void test2(){
        WordDictionary wordDictionary =  new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");

        Assert.assertTrue(wordDictionary.search("."));
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search("aa"));
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search(".a"));
        Assert.assertFalse(wordDictionary.search("a."));
    }
}
