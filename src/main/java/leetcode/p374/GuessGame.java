package leetcode.p374;

public class GuessGame {
    private int picked;
    public  int guess(int num){
        if (num == picked){
            return 0;
        }else if (picked > num){
            return 1;
        }else {
            return -1;
        }
    };
}
