package leetcode.p138;

import java.util.IdentityHashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = null;
        Node newTail = null;

        IdentityHashMap<Node, Node> oldToNewNodeMap = new IdentityHashMap<>();
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.random = head.random;
            oldToNewNodeMap.put(head, newNode);

            if (newHead == null) {
                newHead = newNode;
            }
            if (newTail == null) {
                newTail = newNode;
            }else {
                newTail.next = newNode;
                newTail = newNode;
            }
            head = head.next;
        }

        Node newNode0 = newHead;
        while (newHead != null) {
            if (newHead.random != null) {
                Node newRandomNode = oldToNewNodeMap.get(newHead.random);
                newHead.random = newRandomNode;
            }
            newHead = newHead.next;
        }

        return newNode0;
    }
}
