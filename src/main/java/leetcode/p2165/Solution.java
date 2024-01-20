package leetcode.p2165;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long smallestNumber(long num) {
        if(num == 0){
            return 0;
        } else if (num > 0) {
            PriorityQueue<Long> bitNumbers = new PriorityQueue<>(Comparator.naturalOrder());

            int zeroCount = 0;
            while (num != 0){
                long bitNumber = num % 10;
                if (bitNumber != 0){
                    bitNumbers.offer(bitNumber);
                }else {
                    zeroCount++;
                }
                num /= 10;
            }
            long result = 0;
            boolean flag = true;
            while (!bitNumbers.isEmpty()){
                result *= 10;
                result += bitNumbers.poll();
                if (flag) {
                    for (int i = 0; i < zeroCount; i++) {
                        result *= 10;
                    }
                    flag = false;
                }
            }
            return result;
        }else {
            PriorityQueue<Long> bitNumbers = new PriorityQueue<>(Comparator.reverseOrder());
            num = -num;
            while (num != 0){
                long bitNumber = num % 10;
                bitNumbers.offer(bitNumber);
                num /= 10;
            }
            long result = 0;
            while (!bitNumbers.isEmpty()){
                result *= 10;
                result += bitNumbers.poll();
            }
            result = -result;
            return result;
        }
    }
}
