package leetcode.p1268;

import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie(3);
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
            if (temp == null) {
                results.add(new ArrayList<>());
            }else {
                LinkedList<String> result = new LinkedList<>();
                while (!temp.sortedList.isEmpty()) {
                    String poll = temp.sortedList.poll();
                    result.addFirst(poll);
                }
                for (String s : result) {
                    temp.sortedList.offer(s);
                }
                results.add(result);
            }
        }
        return results;
    }

    public static class Trie {
        private int sortedListLimit;
        public Trie(int kdequeLimit){
            this.sortedListLimit = kdequeLimit;
        }
        private TrieNode root = new TrieNode();
        public void add(String word){
            if (word == null || word.isEmpty()) {
                return;
            }
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.getChildren().containsKey(c)) {
                    temp.getChildren().put(c, new TrieNode(c));
                }
                temp = temp.getChildren().get(c);

                if (temp.sortedList.size() < sortedListLimit) {
                    temp.sortedList.offer(word);
                }else {
                    if (temp.sortedList.peek().compareTo(word) > 0) {
                        temp.sortedList.poll();
                        temp.sortedList.offer(word);
                    }
                }
            }
            if (!temp.getChildren().containsKey(TrieNode.EMPTY_CHAR_REPRESENTATIVE)) {
                temp.getChildren().put(TrieNode.EMPTY_CHAR_REPRESENTATIVE, null);
            }
        }

    }

    public static class TrieNode {
        public static final char EMPTY_CHAR_REPRESENTATIVE = (char)0;

        private Character v;
        private final Map<Character, TrieNode> children = new HashMap<>();
        public PriorityQueue<String> sortedList = new PriorityQueue<>(Comparator.reverseOrder());

        public TrieNode(Character v){
            this.v = v;
        }
        public TrieNode(){}

        public Character getV() {
            return v;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }
    }
}
