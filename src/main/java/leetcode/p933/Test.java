package leetcode.p933;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        RecentCounter counter = new RecentCounter();
        int ping = counter.ping(1);
        Assert.assertEquals(1, ping);

        ping = counter.ping(100);
        Assert.assertEquals(2,  ping);

        ping = counter.ping(3001);
        Assert.assertEquals(3,  ping);

        ping = counter.ping(3002);
        Assert.assertEquals(3,  ping);
    }
}
