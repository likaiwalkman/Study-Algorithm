package leetcode.p1318;

public class Solution {
    public int minFlips(int a, int b, int c) {
        int aOrB = a | b;
        int size = 32;
        int sum = 0;
        while (size > 0){
            boolean aOrBDigitIsOne = aOrB % 2 != 0;
            boolean cDigitIsOne = c % 2 != 0;

            if (aOrBDigitIsOne == cDigitIsOne) {
                System.out.println();
            }else {
                boolean aAlignDigitIsOne = a % 2 != 0;
                boolean bAlignDigitIsOne = b % 2 != 0;

                if (!aOrBDigitIsOne && cDigitIsOne){
                    sum += 1;
                }else if (aOrBDigitIsOne && !cDigitIsOne){
                    if (aAlignDigitIsOne) {
                        sum += 1;
                    }
                    if (bAlignDigitIsOne){
                        sum += 1;
                    }
                }
            }

            a = a >>> 1;
            b = b >>> 1;
            c = c >>> 1;
            aOrB = aOrB >>> 1;
            size--;
        }
        return sum;
    }
}
