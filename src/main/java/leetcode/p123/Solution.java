package leetcode.p123;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[3][];
            for (int j = 0; j < 3; j++) {
                dp[i][j] = new int[2];
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 1; k++) {
                    if (i == 0) {
                        if (k == 1){
                            dp[i][j][k] = -prices[i];
                        }else if (k==0){
                            dp[i][j][k] = 0;
                        }
                        continue;
                    }
                    if (j==0){
                        dp[i][j][0] = 0;

                    }else {
                        dp[i][j][0] = Math.max(dp[i-1][j-1][1]+prices[i], dp[i-1][j][0]);
                    }
                    dp[i][j][1] = Math.max(dp[i-1][j][0]-prices[i], dp[i-1][j][1]);
                }
            }
        }
        return dp[n-1][2][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>(2);

        for (int price : prices) {
            if (item.isEmpty()) {
                item.add(price);
                continue;
            }

            Integer last = item.get(item.size() - 1);
            if (last <= price) {
                if (item.size() == 1) {
                    item.add(price);
                }else {
                    item.set(1, price);
                }
                continue;
            }

            if (item.size() == 1) {
                item = new ArrayList<>();
                item.add(price);
                continue;
            }

            list.add(item);
            item = new ArrayList<>();
            item.add(price);
        }

        if (item.size() > 1) {
            list.add(item);
        }

        System.out.println(list);
        if (list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            List<Integer> integers = list.get(0);
            return integers.get(integers.size()-1) - integers.get(0);
        }
        Stack<List<Integer>> stack = new Stack<>();
        Iterator<List<Integer>> iterator = list.iterator();
        int max = 0;
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            stack.push(next);
            while (stack.size() >= 2){
                int stackOldSize = stack.size();
                List<Integer> firstTop = stack.pop();
                List<Integer> secondTop = stack.pop();
                if ( secondTop.get(1) <= firstTop.get(1) && secondTop.get(0) <= firstTop.get(0)) {
                    int _max = firstTop.get(1) - firstTop.get(0) + secondTop.get(1) - secondTop.get(0);
                    if (_max > max) {
                        max = _max;
                    }
                    List<Integer> element = new ArrayList<>();
                    element.add(secondTop.get(0));
                    element.add(firstTop.get(1));
                    stack.push(element);
                }else {
                    stack.push(secondTop);
                    stack.push(firstTop);
                }
                if (stack.size() == stackOldSize) {
                    break;
                }
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int diff = pop.get(1) - pop.get(0);
            if (heap.size() < 2) {
                heap.offer(diff);
            }else {
                if (heap.peek() < diff) {
                    heap.poll();
                    heap.offer(diff);
                }
            }
        }
        if (heap.size() == 1) {
            max = Math.max(heap.poll(), max);
        }else if (heap.size() >= 2){
            max = Math.max(heap.poll() + heap.poll(), max);
        }
        return max;
    }
}
