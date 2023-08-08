package leetcode.p201;



public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int[] ints = new int[32];
        int size = 32;
        int count = 0;
        while (size > 0){
            int leftBit  = (left  >>> 31-count) % 2 != 0 ? 1 : 0;
            int rightBit = (right >>> 31-count) % 2 != 0 ? 1 : 0;
            if ( leftBit == rightBit ) {
                ints[count] = leftBit;
                count++;
                size--;
            }else {
                break;
            }
        }

        int result = 0;
        count = 0;
        while (count < 32){
            result <<= 1;
            result += ints[count++];
        }
        return result;
    }
}
