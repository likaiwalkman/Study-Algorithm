package leetcode.p48;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        new Solution().rotate(arr);
        System.out.println();
    }

    @org.junit.Test
    public void test2(){
        int[][] arr = {
                {1,2,3,4},
                {5,6,7, 8},
                {9,10,11,12},
                {13,14,15,16},
        };
        new Solution().rotate(arr);
        System.out.println();
    }

    @org.junit.Test
    public void test3(){
        int[][] arr = {
                {1}
        };
        new Solution().rotate(arr);
        System.out.println();
    }
}
