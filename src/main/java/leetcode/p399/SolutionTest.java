package leetcode.p399;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] doubles = new Solution().calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }

    @org.junit.Test
    public void test2(){
        double res = 1.0 / 3.0;
        res *= 3.0;
        System.out.println(res);

        res = 2.0 / 7.0;
        res *= 7.0;
        System.out.println(res);

        double i = 0.3333333333333333;
        double j = 0.9999999999999999;
        System.out.println(i*3.0);
    }
}
