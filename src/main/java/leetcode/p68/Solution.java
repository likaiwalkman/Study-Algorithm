package leetcode.p68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < words.length){
            int continuousLettersCount = 0;
            continuousLettersCount += words[i].length();
            int j = i;
            while (j+1 < words.length && words[j+1].length()+1+continuousLettersCount <= maxWidth){
                continuousLettersCount += words[j+1].length()+1;
                j++;
            }
            int wordCount = j-i+1;
            if (j == words.length-1) {
                StringBuilder builder = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    if (k==i) {
                        builder.append(words[k]);
                    }else {
                        builder.append(" "+words[k]);
                    }
                }
                int diff = maxWidth - builder.length();
                for (int x = 0; x < diff; x++) {
                    builder.append(" ");
                }
                result.add(builder.toString());
            }else {
                StringBuilder builder = new StringBuilder();
                if (wordCount == 1){
                    builder.append(words[i]);
                    int diff = maxWidth - builder.length();
                    for (int x = 0; x < diff; x++) {
                        builder.append(" ");
                    }
                }else {
                    int charCount = 0;
                    for (int k = i; k <= j; k++) {
                        charCount += words[k].length();
                    }
                    int averageSpaceCount = (maxWidth - charCount) / (wordCount - 1);
                    int remainSpaceCount = (maxWidth - charCount) % (wordCount - 1);
                    StringBuilder averageSpace = new StringBuilder();
                    for (int x = 0; x < averageSpaceCount; x++) {
                        averageSpace.append(" ");
                    }
                    for (int k = i; k <= j; k++) {
                        if (k == i) {
                            builder.append(words[k]);
                        }else {
                            if (remainSpaceCount != 0) {
                                builder.append(" ");
                                remainSpaceCount--;
                            }
                            builder.append(averageSpace);
                            builder.append(words[k]);
                        }
                    }
                }
                result.add(builder.toString());
            }

            i = j+1;
        }
        return result;
    }
}
