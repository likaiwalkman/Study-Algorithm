package leetcode.p228;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<String> strings = new Solution().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        System.out.println(strings);
    }
}
