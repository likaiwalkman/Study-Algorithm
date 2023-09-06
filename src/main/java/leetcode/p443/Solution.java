package leetcode.p443;

public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int readerIndex = 0;
        int writeIndex = 0;
        int count = 0;
        while (readerIndex < n){
            int j=readerIndex+1;
            while (j<n && chars[j] == chars[readerIndex]){
                j++;
            }
            int seq = j-readerIndex;
            if (seq == 1) {
                count++;
                chars[writeIndex++]=chars[readerIndex];
            }else {
                count++;
                chars[writeIndex++]=chars[readerIndex];
                String seqStr = ""+seq;
                for (int i = 0; i < seqStr.length(); i++) {
                    chars[writeIndex++]=seqStr.charAt(i);
                }
                count += seqStr.length();
            }
            readerIndex=j;
        }
        return count;
    }
}
