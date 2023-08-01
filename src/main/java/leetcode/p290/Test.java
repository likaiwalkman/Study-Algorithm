package leetcode.p290;

public class Test {
    @org.junit.Test
    public void test1(){
        String pattern = "abba", s = "dog cat cat dog";
        boolean b = new Solution().wordPattern(pattern, s);
        System.out.println(b);
    }
}
