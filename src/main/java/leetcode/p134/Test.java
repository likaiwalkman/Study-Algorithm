package leetcode.p134;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        int i = new Solution().canCompleteCircuit(gas, cost);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        int[] gas = {2,3,4}, cost = {3,4,3};
        int i = new Solution().canCompleteCircuit(gas, cost);
        Assert.assertEquals(-1, i);
    }

    @org.junit.Test
    public void test3(){
        int[] gas = {3,3,4}, cost = {3,4,4};
        int i = new Solution().canCompleteCircuit(gas, cost);
        Assert.assertEquals(-1, i);
    }
}
