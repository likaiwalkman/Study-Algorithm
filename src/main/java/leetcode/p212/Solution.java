package leetcode.p212;

import java.util.*;

class TrieNode {
    public Character val;
    public String stopWord;
    public TrieNode parent;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(Character val, TrieNode parent){
        this.val = val;
        this.parent = parent;
    }
}

class WordDictionary {
    public WordDictionary() {}

    public final TrieNode root = new TrieNode(null, null);

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
                TrieNode newTrieNode = new TrieNode(c, temp);
                temp.children.put(c, newTrieNode);
                temp = newTrieNode;
            }else {
                temp = t;
            }
            index++;
        }
        temp.stopWord = word;
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

    public void deleteWord(String word, int startIndex, int endBorderIndex) {
        if (startIndex == endBorderIndex){
            return;
        }

        TrieNode targetTrieNode = startsWith0(word.substring(startIndex, endBorderIndex));
        if (targetTrieNode == null || !targetTrieNode.children.containsKey(null)){
            return;
        }
        targetTrieNode.children.remove(null);
        if (targetTrieNode.children.size() == 0) {
            TrieNode parent = targetTrieNode.parent;
            parent.children.remove(targetTrieNode.val);
            targetTrieNode.parent = null;
            if (!search(word.substring(startIndex, endBorderIndex-1))){
                deleteWord(word, startIndex, endBorderIndex-1);
            }
        }
    }

    public void deleteWord(String word) {
        if (word == null || word.length() == 0){
            return;
        }

        deleteWord(word, 0, word.length());
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        WordDictionary dict = new WordDictionary();
        TrieNode trieNode = dict.root;

        for (String word : words) {
            dict.insert(word);
        }
        List<String> results = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                iter(board, trieNode, results, i, j, m, n);
            }
        }

        return new ArrayList<>(results);
    }

    public void iter(char[][] board, TrieNode trieNode, List<String> results, int i, int j, int m, int n){

        char c = board[i][j];
        if (trieNode == null || !trieNode.children.containsKey(c)){
            return;
        }
        //side effect
        board[i][j] = '#';

        if (trieNode.children.get(c).children.containsKey(null)) {
            TrieNode endNode = trieNode.children.get(c);
            String stopWord = endNode.stopWord;
            endNode.stopWord = null;
            if (stopWord != null){
                results.add(stopWord);
            }
        }

        if (0 <= i-1 && board[i-1][j] != '#') {
            iter(board, trieNode.children.get(c), results,i-1, j, m, n);
        }
        if (i+1 < m && board[i+1][j] != '#') {
            iter(board, trieNode.children.get(c), results, i+1, j, m, n);
        }
        if (0 <= j-1 && board[i][j-1] != '#') {
            iter(board, trieNode.children.get(c), results, i, j-1, m, n);
        }
        if (j+1 < n && board[i][j+1] != '#') {
            iter(board, trieNode.children.get(c), results, i, j+1, m, n);
        }

        //eliminate side effect
        board[i][j] = c;
    }
}
