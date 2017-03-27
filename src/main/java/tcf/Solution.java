package tcf;

public class Solution {
    public static void main(String[] args) {
        int v = m1();
        System.out.println(v);
    }

    static int m1(){
        try {
            if (true){
                throw new Exception("err");
            }
            return 1;
        } catch (Exception e){
            System.out.println("err");
            return 0;
        } finally {
            System.out.println("over");
            return 3;
        }
    }
}
