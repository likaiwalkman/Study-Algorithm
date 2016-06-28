package stack;

import java.util.Stack;

public class IteratorNode {
    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> left = new Node<Integer>(1);
        Node<Integer> right = new Node<Integer>(3);
        root.setLeft(left);
        root.setRight(right);

        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> five = new Node<Integer>(5);
        left.setLeft(four);
        left.setRight(five);

        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> seven = new Node<Integer>(7);
        five.setLeft(six);
        five.setRight(seven);

        Node<Integer> eight = new Node<Integer>(8);
        seven.setRight(eight);


        iteratorWithStack(root);

    }

    public static void iteratorWithStack(Node<Integer> root) {
        Node<Integer> p, l, r;

        Stack stack = new Stack();
        if (root == null) {
            return;
        } else {
            p = root;
            l = root.getLeft();
            r = root.getRight();
            if (r != null) {
                stack.push(r);
            }
            stack.push(p.getVal());
            if ( l != null ){
                stack.push(l);
            }
            while (stack.size() != 0){
                Object pop = stack.pop();
                if (pop instanceof Node) {
                    p =(Node)pop;
                    l = p.getLeft();
                    r = p.getRight();
                    if (r!=null){
                        stack.push(r);
                    }
                    stack.push(p.getVal());
                    if (l!=null){
                        stack.push(l);
                    }
                } else {
                    //process each element
                    System.out.println(pop);
                }
            }
        }
    }
}
