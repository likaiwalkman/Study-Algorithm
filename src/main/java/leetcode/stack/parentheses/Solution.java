package leetcode.stack.parentheses;

import java.util.LinkedList;

/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

The brackets must close in the correct order,
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

* */
/**
 * Created by victor on 16/2/2.
 */
public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> characters = new LinkedList<Character>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Character top = characters.peek();

            if (c == ']'){
                if (top == null || top!='['){
                    return false;
                } else {
                    characters.pop();
                }
            } else if (c == '}'){
                if (top == null || top!='{'){
                    return false;
                } else {
                    characters.pop();
                }
            } else if (c == ')'){
                if (top == null || top!='('){
                    return false;
                } else {
                    characters.pop();
                }
            }else{
                characters.push(c);
            }
        }
        return characters.size() == 0 ;
    }

    public static void main(String[] args) {
        LinkedList<Character> characters = new LinkedList<Character>();
        Character c =
                characters.peek();
        boolean b = new Solution().isValid("()");
        System.out.println(b);
        //LinkedList<Character> cs = new LinkedList<Character>();
        //cs.peek();
    }
}
