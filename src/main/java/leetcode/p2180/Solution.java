package leetcode.p2180;

public class Solution {
    public int countEven(int num) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            int k = i;
            int sum = 0;
            while (k != 0 ){ //&& k % 10 !=0) {
                sum += (k % 10);
                k = k / 10;
            }
            if( sum % 2 == 0) {
                System.out.print("\t"+i);
                total++;
            }
        }
        return total;
    }
}
