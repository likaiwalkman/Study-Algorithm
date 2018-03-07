package bitmod;

import java.util.Stack;

public class DigitsPresentation {
    public static void main(String[] args) {
        int idem = 53;
        int digit;
        //int level = 0;
        Stack<Integer> stack = new Stack<>();
        while( idem != 0 ){
            digit = idem % 2;
            idem = idem / 2;
            System.out.println(digit);
            stack.push(digit);
            //System.out.println(digit+", "+ level);
            //level ++;
        }
        System.out.println();
        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }

}
