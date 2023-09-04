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
        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            List<String> result = trie.top3PrefixMatchedList(substring);
            results.add(result);
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
        public List<String> top3PrefixMatchedList(String prefix){
            List<String> result = new ArrayList<>();
            TrieNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (temp.getChildren().containsKey(c)) {
                    temp = temp.getChildren().get(c);
                }else {
                    temp = null;
                    break;
                }
            }
            if (temp == null) {
                return result;
            }

            StringBuilder builder = new StringBuilder(prefix);
            iter(temp, result, builder, 3);
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
