package leetcode.p2166;

public class Bitset {

    public static String binaryPresentation(byte b){
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 8; j++) {
            boolean isDigitOne = (b & (0x80 >> j)) != 0;
            builder.append(isDigitOne ? "1" : "0");
        }
        return builder.toString();
    }

    private final byte[] bytes;
    private final int unusedPrefixZeroCount;
    private int oneDigitCount;

    public Bitset(int size) {
        int len = size / 8;
        int remain = size % 8;
        if (remain != 0) {
            len++;
            unusedPrefixZeroCount = 8-remain;
        }else {
            unusedPrefixZeroCount = 0;
        }
        bytes = new byte[len];
    }

    public void fix(int idx) {
        int fullIndex = idx + unusedPrefixZeroCount;
        int zeroIndex = bytes.length*8 - 1 - fullIndex;

        int targetArrIndex = zeroIndex / 8;
        int digitIdx = zeroIndex % 8;

        byte b = bytes[targetArrIndex];
        if(((1 << digitIdx) & b) == 1 << digitIdx){
            return;
        }
        oneDigitCount++;
        bytes[targetArrIndex] = (byte)((1<<digitIdx) | b);
    }

    public void unfix(int idx) {
        int fullIndex = idx + unusedPrefixZeroCount;
        int zeroIndex = bytes.length*8 - 1 - fullIndex;

        int targetArrIndex = zeroIndex / 8;
        int digitIdx = zeroIndex % 8;

        byte b = bytes[targetArrIndex];
        if(((1 << digitIdx) & b) == 0){
            return;
        }
        oneDigitCount--;
        bytes[targetArrIndex] = (byte)( (0xff ^ (1<<digitIdx)) & b);
    }

    public void flip() {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)((int)bytes[i] ^ 0xff);
        }
        oneDigitCount = bytes.length*8 - unusedPrefixZeroCount - oneDigitCount;
    }

    public boolean all() {
        return oneDigitCount == bytes.length*8 - unusedPrefixZeroCount;
    }

    public boolean one() {
        return oneDigitCount > 0;
    }

    public int count() {
        return oneDigitCount;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int idx = bytes.length-1-i;
            String byteStr = binaryPresentation(bytes[idx]);
            if (builder.length() == 0) {
                builder.append(byteStr.substring(unusedPrefixZeroCount));
            }else{
                builder.append(byteStr);
            }
        }
        return builder.toString();
    }
}
