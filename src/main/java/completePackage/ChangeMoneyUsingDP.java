package completePackage;


import java.util.Arrays;

public class ChangeMoneyUsingDP {
    public static void main(String[] args) {
        final int[] coins = new int[]{1, 3, 5};
        long start = System.currentTimeMillis();
        int[] results = changeMoney(40, coins);
        System.out.println(Arrays.toString(results));
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);
    }

    static class State{
        int[] winner = null;

        void changeMoneySolution(int totalVal, int[] coins, int[] prev){
            int coinsLen = coins.length;
            if (totalVal == 0){
                return;
            }
            int[] solution = null;
            if (prev != null) {
                solution = new int[coinsLen];
                for (int i = 0; i < prev.length; i++) {
                    solution[i] = prev[i];
                }
            }

            for (int i = 0; i < coinsLen; i++) {
                if (totalVal > coins[i]) {
                    int[] forwardingSolution = new int[coins.length];
                    forwardingSolution[i]++;
                    if (solution != null) {
                        for (int j = 0; j < solution.length; j++) {
                            forwardingSolution[j] += solution[j];
                        }
                    }

                    if (totalVal > coins[i]){
                        changeMoneySolution(totalVal-coins[i], coins, forwardingSolution);
                    }
                }else if(totalVal == coins[i]){
                    int[] forwardingSolution = new int[coins.length];
                    forwardingSolution[i]++;
                    if (solution != null) {
                        for (int j = 0; j < solution.length; j++) {
                            forwardingSolution[j] += solution[j];
                        }
                    }
                    winner = compete(forwardingSolution, winner);
                }else{
                    solution = null;
                }
            }
        }

    }
    static int[] changeMoney(final int total, final int[] coins){

        State state = new State();
        state.changeMoneySolution(total, coins, null);
        int[] winner = state.winner;
        return winner;
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
