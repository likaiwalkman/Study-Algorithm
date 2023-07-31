package leetcode.p134;

public class Solution {
    static boolean debug = false;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int x = 0; x < n; x++) {
            int remaining = 0;
            int y = x;
            if (debug) {
                System.out.println("-----------");
                System.out.println("detect index: "+x);
            }
            int count = 0;
            while (gas[y] + remaining >= cost[y]) {
                if (n == 1) {
                    return x;
                }

                if (debug){
                    System.out.println("index y="+y+"  reachable\t");
                }
                remaining += (gas[y] - cost[y]);
                if (y == x && ++count == 2){
                    return x;
                }
                y = (y+1) % n;
            }
        }
        return -1;
    }
}
