package leetcode.p502;

import leetcode.common.CallableTaskCostWatcher;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(4, maximizedCapital);
    }

    @org.junit.Test
    public void test2(){
        int k = 3, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,2};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(6, maximizedCapital);
    }

    @org.junit.Test
    public void test3(){
        int k = 1, w = 2;
        int[] profits = {1,2,3}, capital = {1, 1, 2};
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        Assert.assertEquals(5, maximizedCapital);
    }

    @org.junit.Test
    public void test4(){
        int k = 100000, w = 100000;
        int[] profits = new int[k];
        int[] capital = new int[k];

        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int x = random.nextInt(k);
            capital[i] = x;
            profits[i] = k;
        }
        Pair<Object, Long> pair = new CallableTaskCostWatcher<>(() -> {
            //Arrays.sort(capital);
            return null;
        }).timeCost();
        System.out.println(pair.getRight());
        int maximizedCapital = new Solution().findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
        //Assert.assertEquals(5, maximizedCapital);
    }

}
