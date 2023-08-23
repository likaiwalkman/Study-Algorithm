package leetcode.p30;

import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        List<Integer> list = new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(list);
    }

    @org.junit.Test
    public void test2(){
        List<Integer> list = new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        System.out.println(list);
    }

    @org.junit.Test
    public void test3(){
        List<Integer> list = new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(list);
    }

}
