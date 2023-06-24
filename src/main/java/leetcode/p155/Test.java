package leetcode.p155;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        Assert.assertEquals(-3, minStack.getMin());
        Assert.assertEquals(-3, minStack.top());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }
}
