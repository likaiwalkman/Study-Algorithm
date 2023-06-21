package leetcode.p1455;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int searchWordStart = 0;

        boolean charIsBlank = true;
        int wordCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            boolean currentCharIsBlank = c == ' ';
            if (charIsBlank && !currentCharIsBlank) {
                wordCount++;
                searchWordStart = 0;
            }

            charIsBlank = currentCharIsBlank;

            if(!charIsBlank && searchWordStart >=0 ){
                if (searchWord.charAt(searchWordStart) == sentence.charAt(i)) {
                    searchWordStart++;
                    if (searchWordStart == searchWord.length()){
                        return wordCount;
                    }
                }else {
                    searchWordStart = -1;
                }
            }
        }

        return -1;

    }
}
