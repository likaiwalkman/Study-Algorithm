package leetcode.p208;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        Trie trie = new Trie();
        trie.insert("abcd");
        Assert.assertTrue(trie.search("abcd"));
        Assert.assertFalse(trie.search("abc"));
    }
}
