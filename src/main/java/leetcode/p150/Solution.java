package leetcode.p150;

import java.util.*;

public class Solution {
    static Set<String> OPERATORS = new HashSet<>();
    static {
        OPERATORS.add("+");
        OPERATORS.add("-");
        OPERATORS.add("*");
        OPERATORS.add("/");
    }
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>();
        for (String token : tokens) {
            list.add(token);
        }
        return eval(list);
    }

    public int eval(List<String> list){
        if (list.size() == 1){
            return Integer.parseInt(list.get(0));
        }
        int firstOperatorIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (OPERATORS.contains(list.get(i))) {
                firstOperatorIndex = i;
                break;
            }
        }
        int num = 0;
        String operand1 = list.get(firstOperatorIndex - 2);
        String operand2 = list.get(firstOperatorIndex - 1);
        int operandNum1 = Integer.parseInt(operand1);
        int operandNum2 = Integer.parseInt(operand2);

        switch (list.get(firstOperatorIndex)){
            case "+":
                num = operandNum1 + operandNum2;
                break;
            case "-":
                num = operandNum1 - operandNum2;
                break;
            case "*":
                num = operandNum1 * operandNum2;
                break;
            case "/":
                num = operandNum1 / operandNum2;
                break;
        }
        list.set(firstOperatorIndex-2, num+"");
        list.remove(firstOperatorIndex);
        list.remove(firstOperatorIndex-1);
        return eval(list);
    }
}
