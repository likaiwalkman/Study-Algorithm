package leetcode.p211;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TrieNode {
    static final TrieNode NULL_OBJECT = new TrieNode(null);
    public Character val;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(Character val){
        this.val = val;
    }
}

class WordDictionary {
    private final TrieNode root = new TrieNode(null);

    public WordDictionary() {}

    public void deleteWord(String word, int startIndex, int endBorderIndex, TrieNode trieNode) {
        if (startIndex == endBorderIndex){
            return;
        }

        Character[] chars = new Character[endBorderIndex-startIndex+1];
        for (int i = startIndex; i < endBorderIndex; i++) {
            chars[i] = word.charAt(i);
        }

        boolean found = seqContains(chars, startIndex, trieNode);;
        if (!found){
            return;
        }
        TrieNode temp = root;
        int index = startIndex;
        seqContains(chars, index, trieNode);

    }

    public void deleteWord(String word) {
        if (word == null || word.length() == 0){
            return;
        }

        boolean found = search(word);
        if (!found){
            return;
        }
        TrieNode temp = root;

    }

    public void addWord(String word) {
        TrieNode temp = root;
        char[] charArray = word.toCharArray();
        for (char element : charArray) {
            if (!temp.children.containsKey(element)) {
                temp.children.put(element, new TrieNode(element));
            }
            temp = temp.children.get(element);
        }
        temp.children.put(null, TrieNode.NULL_OBJECT);
    }

    public boolean seqContains(Character[] chars, int index, TrieNode trieNode){
        Character c = chars[index];
        if (index == chars.length-1 && trieNode.children.containsKey(null)){
            return true;
        }
        List<TrieNode> children = trieNode.children.values().stream().filter(v -> v.val != null).collect(Collectors.toList());
        if (((Character)'.').equals(c)) {
            for (TrieNode child : children) {
                boolean b = seqContains(chars, index + 1, child);
                if (b){
                    return true;
                }
            }
            return false;
        }else {
            if (c == null){
                return trieNode.children.containsKey(null);
            }else {
                if (!trieNode.children.containsKey(chars[index])) {
                    return false;
                }
                return seqContains(chars, index + 1, trieNode.children.get(chars[index]));
            }
        }
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Character[] charArrayWithEnding = new Character[charArray.length+1];
        for (int i = 0; i < charArray.length; i++) {
            charArrayWithEnding[i] = charArray[i];
        }
        return seqContains(charArrayWithEnding, 0, root);
    }
}