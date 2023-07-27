package leetcode.p58;

public class Solution {
    public int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int lastWordLength = 0;
        int wordLengthCounter = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                if (wordLengthCounter !=0) {
                    lastWordLength = wordLengthCounter;
                }
                wordLengthCounter = 0;
            }else {
                wordLengthCounter++;
            }
        }

        if (wordLengthCounter !=0) {
            return wordLengthCounter;
        }else {
            return lastWordLength;
        }
    }
}
