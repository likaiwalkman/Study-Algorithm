package leetcode.p208;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

class Trie {
    private final TrieNode root = new TrieNode(null);
    public Trie() {}

    public void insert(String word) {
        IntStream intStream = word.codePoints();
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        TrieNode temp = root;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (!temp.children.containsKey(element)) {
                temp.children.put(element, new TrieNode(element));
            }
            temp = temp.children.get(element);
        }
        temp.children.put(null, TrieNode.NULL_OBJECT);
    }

    public boolean search(String word) {
        IntStream intStream = word.codePoints();
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        TrieNode temp = root;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            boolean containsKey = temp.children.containsKey(element);
            if (!containsKey) {
                return false;
            }
            temp = temp.children.get(element);
        }
        return temp.children.containsKey(null);
    }

    public boolean startsWith(String prefix) {
        IntStream intStream = prefix.codePoints();
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        TrieNode temp = root;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            boolean containsKey = temp.children.containsKey(element);
            if (!containsKey) {
                return false;
            }
            temp = temp.children.get(element);
        }
        return true;
    }
}

class TrieNode {
    static final TrieNode NULL_OBJECT = new TrieNode(null);
    public Integer val;
    public Map<Integer, TrieNode> children = new HashMap<>();

    public TrieNode(Integer val){
        this.val = val;
    }
}
