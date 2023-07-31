package leetcode.p151;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = new Solution().reverseWords("the sky is blue");
        System.out.println(s);
    }

    @org.junit.Test
    public void test2(){
        String s = new Solution().reverseWords("the sky is blue");
        System.out.println(s);
    }

    @org.junit.Test
    public void test3(){
        String s = new Solution().reverseWords("   the sky is blue ");
        System.out.println(s);
    }

    @org.junit.Test
    public void test4(){
        String s = new Solution().reverseWords("   the  sky is blue ");
        System.out.println(s);
    }
}
