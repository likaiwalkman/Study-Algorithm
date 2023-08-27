package leetcode.p295;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        Assert.assertEquals(1.0,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(3);
        Assert.assertEquals(2.0,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(4);
        Assert.assertEquals(2.5,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(5);
        Assert.assertEquals(3.0,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(6);
        Assert.assertEquals(3.5,  medianFinder.findMedian(), 0.0);
        medianFinder.addNum(7);
        Assert.assertEquals(4.0,  medianFinder.findMedian(), 0.0);
    }

    @Test
    public void test2(){
        MedianFinder medianFinder = new MedianFinder();
        Object[][] inputs = {
                {6, 6.0},
                {10, 8.0},
                {2, 6.0},
                {6, 6.0},
                {5, 6.0},
                {0, 5.5},
                {6, 6.0},
                {3, 5.5},
                {1, 5.0},
                {0, 4.0},
                {0, 3.0},
        };
        for (int i = 0; i < inputs.length; i++) {
            Object[] input = inputs[i];
            medianFinder.addNum((int)input[0]);
            double v = (double) input[1];
            Assert.assertEquals(v,  medianFinder.findMedian(), 0.0);
            System.out.println(input[0] +" " +i +" "+medianFinder.findMedian());
        }
    }
}
