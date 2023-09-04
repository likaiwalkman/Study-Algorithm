package leetcode.p1268;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        if (products != null) {
            for (String product : products) {
                trie.add(product);
            }
        }
        List<List<String>> results = new ArrayList<>();
        TrieNode temp = trie.root;
        for (int i = 1; i <= searchWord.length(); i++) {
            char c = searchWord.charAt(i - 1);
            if (temp != null) {
                temp = temp.getChildren().get(c);
            }
            String substring = searchWord.substring(0, i);
            if (results.isEmpty() || results.get(results.size()-1).size() != 0) {
                List<String> result = trie.topCountedPrefixMatchedList(temp, substring, 3);
                results.add(result);
            }else {
                results.add(new ArrayList<>());
            }
        }
        return results;
    }

    public static class Trie {
        private TrieNode root = new TrieNode();
        public void add(String word){
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.getChildren().containsKey(c)) {
                    temp.getChildren().put(c, new TrieNode(c));
                }
                temp = temp.getChildren().get(c);
            }
            if (!temp.getChildren().containsKey(TrieNode.EMPTY_CHAR_REPRESENTATIVE)) {
                temp.getChildren().put(TrieNode.EMPTY_CHAR_REPRESENTATIVE, null);
            }
        }
        public List<String> topCountedPrefixMatchedList(TrieNode temp, String prefix, int count){
            List<String> result = new ArrayList<>();
            if (temp == null) {
                return result;
            }

            StringBuilder builder = new StringBuilder(prefix);
            iter(temp, result, builder, count);
            return result;
        }

        private void iter(TrieNode node, List<String> result, StringBuilder builder, int count){
            TreeMap<Character, TrieNode> children = node.getChildren();
            if (children.containsKey(TrieNode.EMPTY_CHAR_REPRESENTATIVE)) {
                if (result.size() < count) {
                    result.add(builder.toString());
                }
                if (result.size() == count) {
                    return;
                }
            }
            for (Character c : children.keySet()) {
                if(c != TrieNode.EMPTY_CHAR_REPRESENTATIVE){
                    builder.append(c);
                    iter(children.get(c), result, builder, count);
                    builder.deleteCharAt(builder.length()-1);
                }
            }
        }

    }

    public static class TrieNode {
        public static final char EMPTY_CHAR_REPRESENTATIVE = (char)0;

        private Character v;
        private final TreeMap<Character, TrieNode> children = new TreeMap<>();

        public TrieNode(Character v){
            this.v = v;
        }
        public TrieNode(){}

        public Character getV() {
            return v;
        }

        public TreeMap<Character, TrieNode> getChildren() {
            return children;
        }
    }
}
