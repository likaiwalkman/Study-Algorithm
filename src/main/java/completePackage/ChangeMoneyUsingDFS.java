package completePackage;

import java.util.Arrays;


public class ChangeMoneyUsingDFS {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] ints = changeMoney(40, new int[]{1, 3, 5});
        System.out.println(Arrays.toString(ints));
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);
    }

    static int[] changeMoney(int total, int coins[]){
        int len = coins.length;
        int[][] results = new int[len][len];

        if (total == 0){
            int[] one = new int[len];
            return one;
        }

        for (int i = 0; i < len; i++) {
            if (total >= coins[i]) {
                int[] one = new int[len];
                one[i] = 1;
                results[i] = add(one, changeMoney(total-coins[i], coins));
            }else {
                results[i] = null;
            }
        }
        int[] winner = null;
        for (int[] result : results) {
            winner = compete(winner, result);
        }
        return winner;
    }
    static int[] add(int[] a, int[] b){
        if (a==null || b== null){
            return null;
        }
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = a[i] + b[i];
        }
        return a;
    }
    static int[] compete(int[] a, int[] b){
        if (a==null && b==null) return null;
        if (a==null && b!=null) return b;
        if (a!=null && b==null) return a;
        if (sum(a) >= sum(b)) {
            return b;
        }else {
            return a;
        }
    }
    static int sum(int[] a){
        int sum = 0;
        for (int inc : a) {
            sum += inc;
        }
        return sum;
    }
}
