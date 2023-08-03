package leetcode.p228;

import org.junit.Assert;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test1(){
        List<String> strings = new Solution().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        String exp = "[0,2->4,6,8->9]";
        Assert.assertEquals(exp, strings.toString().replace(" ", ""));
        System.out.println(strings);
    }
}
