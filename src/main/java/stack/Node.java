package stack;

public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T val;

    public Node(T val){
        this.val = val;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}
