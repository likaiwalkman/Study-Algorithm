package leetcode.p208;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

class Trie {
    private final TrieNode root = new TrieNode(null);
    public Trie() {}

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        int index = 0;
        TrieNode temp = root;
        while (index < word.length()) {
            char c = word.charAt(index);
            TrieNode t = temp.children.get(c);
            if (t == null) {
                TrieNode newTrieNode = new TrieNode(c);
                temp.children.put(c, newTrieNode);
                temp = newTrieNode;
            }else {
                temp = t;
            }
            index++;
        }
        temp.children.put(null, null);
    }

    public boolean search(String word) {
        TrieNode trieNode = startsWith0(word);
        return trieNode != null && trieNode.children.containsKey(null);
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = startsWith0(prefix);
        return trieNode != null;
    }

    public TrieNode startsWith0(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }

        int index = 0;
        TrieNode temp = root;
        while (temp != null && index < prefix.length()) {
            char c = prefix.charAt(index);
            temp = temp.children.get(c);
            index++;
        }
        return temp;
    }

}

class TrieNode {
    static final TrieNode NULL_OBJECT = new TrieNode(null);
    public Character val;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(Character val){
        this.val = val;
    }
}
