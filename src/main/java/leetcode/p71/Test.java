package leetcode.p71;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = new Solution().simplifyPath("/home/");
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().simplifyPath("/../");
    }

    @org.junit.Test
    public void test3(){
        String s = new Solution().simplifyPath("/home//foo/");
    }

    @org.junit.Test
    public void test4(){
        String s = new Solution().simplifyPath("/a/./b/../../c/");
    }
}
