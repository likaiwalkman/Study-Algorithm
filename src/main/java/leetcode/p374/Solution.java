package leetcode.p374;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        while(i != j){
            int k =  i + (j-i)/2;
            int guessResult = guess(k);
            if(guessResult == 0){
                return k;
            }else if(guessResult == 1){
                i = k+1;
            }else if(guessResult == -1){
                j = k-1;
            }
        }
        return i;
    }
}