package leetcode.p204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        int[] ints = new int[n];
        Arrays.fill(ints, 1);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (ints[i] == 1) {
                count++;
                if ((long)i * i < n) {
                    for (int j = i*i; j < n; j+=i) {
                        ints[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
