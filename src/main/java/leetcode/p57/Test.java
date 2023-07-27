package leetcode.p57;

public class Test {
    @org.junit.Test
    public void test1(){
        int[][] res = new Solution().insert(new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16}
        }, new int[]{4, 8});
        System.out.println(res);
    }

    @org.junit.Test
    public void test2(){
        int[][] res = new Solution().insert(new int[][]{}, new int[]{4, 8});
        System.out.println(res);
    }

    @org.junit.Test
    public void test3(){
        int[][] res = new Solution().insert(new int[][]{new int[]{1,5}}, new int[]{0,0});
        System.out.println(res);
    }

    @org.junit.Test
    public void test4(){
        int[][] res = new Solution().insert(new int[][]{
                new int[]{2,5},
                new int[]{6,7},
                new int[]{8,9}
        }, new int[]{0,1});
        System.out.println(res);
    }
}
