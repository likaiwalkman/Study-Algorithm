package leetcode.p155;

class Node {
    Node next;
    int val;
}

public class MinStack {
    static Node TAIL = new Node();
    Node head = TAIL;
    Node minValHead = TAIL;
    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node();
        node.val = val;
        node.next = head;
        head = node;

        if (minValHead == TAIL) {
            Node n = new Node();
            n.val = val;
            n.next = minValHead;
            minValHead = n;
        }else {
            Node n = new Node();
            n.val = minValHead.val < val ? minValHead.val : val;
            n.next = minValHead;
            minValHead = n;
        }
        System.out.println();
    }

    public void pop() {
        if (head == TAIL) {
            return;
        }
        Node next = head.next;
        head = next;

        minValHead = minValHead.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minValHead.val;
    }
}
