package bitmod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DigitsPresentation {
    public static void main(String[] args) {
        int idem = 5;
        List<Integer> digits = digits(idem);
        System.out.println(digits);

        System.out.println(idem(new BigDecimal(3), digits(5)));

    }
    static BigDecimal idem(BigDecimal base, List<Integer> list){
        if (list.size() == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal result = BigDecimal.ONE;
        BigDecimal prev = base;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 1) {
                result = result.multiply(prev);
            }
            prev = prev.pow(2);
        }
        return result;
    }
    public static List<Integer> digits(int idem){
        List<Integer> list = new ArrayList<>();

        int digit;
        //int level = 0;
        Stack<Integer> stack = new Stack<>();
        while( idem != 0 ){
            digit = idem % 2;
            idem = idem / 2;
            System.out.println(digit);
            stack.push(digit);
            list.add(digit);
            //System.out.println(digit+", "+ level);
            //level ++;
        }
        System.out.println();
        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
        return list;
    }

}
