package leetcode.p1268;


import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        List<List<String>> results = new Solution().suggestedProducts(products, "mouse");
        for (List<String> result : results) {
            System.out.println(result);
        }
    }
}
