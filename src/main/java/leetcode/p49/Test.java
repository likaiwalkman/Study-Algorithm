package leetcode.p49;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<List<String>> lists = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    @org.junit.Test
    public void test2(){
        List<List<String>> lists = new Solution().groupAnagrams(new String[]{""});
        System.out.println(lists);
    }

    @org.junit.Test
    public void test3(){
        List<List<String>> lists = new Solution().groupAnagrams(new String[]{"a"});
        System.out.println(lists);
    }
}
