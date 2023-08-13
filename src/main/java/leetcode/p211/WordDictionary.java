package leetcode.p211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
//    private final TrieNode root = new TrieNode(null);
//
//    public WordDictionary() {}
//
//    public void addWord(String word) {
//        TrieNode temp = root;
//        char[] charArray = word.toCharArray();
//        for (char element : charArray) {
//            if (!temp.children.containsKey(element)) {
//                temp.children.put(element, new TrieNode(element));
//            }
//            temp = temp.children.get(element);
//        }
//        temp.children.put(null, TrieNode.NULL_OBJECT);
//    }
//
//    public Object[] seqContains(char[] chars, int index, TrieNode trieNode){
//        char c = chars[index];
//        if (c != '.') {
//            c
//        }else {
//
//        }
//    }
//
//    public boolean search(String word) {
//        TrieNode temp = root;
//        char[] charArray = word.toCharArray();
//        for (char element : charArray) {
//            if ('.' != element) {
//                if (!temp.children.containsKey(element)) {
//                    return false;
//                }
//                temp = temp.children.get(element);
//            }else {
//                for (Character c : temp.children.keySet()) {
//                    if (c == null) {
//                        continue;
//                    }
//                    temp
//                }
//            }
//        }
//        return true;
//    }
}

class TrieNode {
    static final TrieNode NULL_OBJECT = new TrieNode(null);
    public Character val;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(Character val){
        this.val = val;
    }
}