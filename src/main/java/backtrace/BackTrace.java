package backtrace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by kai_li on 2016/1/22.
 * help test : http://www.brainmetrix.com/8-queens/
 */
public class BackTrace {

    public static Node initNodes(int n) {
        Node root = new Node();
        root.val = -1;
        root.children = new LinkedList<Node>();
        Node[] nodes = new Node[n * n];
        for (int i = 0; i < n * n; i++) {
            nodes[i] = new Node();
            nodes[i].val = i + 1;
        }
        for (int i = 0; i < (n * n); i++) {
            if (nodes[i].children == null) {
                nodes[i].children = new LinkedList<Node>();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    nodes[i * n + j].children.add(nodes[(i + 1) * n + k]);
                }
            }
        }
        for (Node node : nodes) {
            root.children.add(node);
        }
        return root;
    }

    public static boolean isTop(Node node, Node root) {
        if (node == null) {
            throw new IllegalArgumentException("node must be not null");
        }
        if (root == null || root.children == null || root.children.size() == 0) {
            throw new IllegalArgumentException("nodes must be not null");
        }
        for (int i = 0; i < root.children.size(); i++) {
            if (node == root.children.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static int getColIndex(Node node, int n){
        return node.val % n;
    }

    public static int getRowIndex(Node node, int n){
        return node.val / n;
    }

    public static boolean isLeaf(Node node) {

        if (node == null) {
            throw new IllegalArgumentException("node must be not null");
        }
        return node.children == null || node.children.size() == 0;
    }

    public static boolean compatible(Node node, Set<Node> path, int n){
        if (path.size() == 0) return true;
        for (Node p : path) {
            boolean b = compatible(node,p,n);
            if (!b) {
                return b;
            }
        }
        return true;
    }
    public static boolean compatible(Node a, Node b, int n){
        int aRowIndex = getRowIndex(a, n);
        int bRowIndex = getRowIndex(b, n);
        int aColIndex = getColIndex(a, n);
        int bColIndex = getColIndex(b, n);
        if (aRowIndex == bRowIndex){
            return false;
        }
        if (aColIndex == bColIndex) {
            return false;
        }
        if (aRowIndex+aColIndex == bRowIndex+bColIndex) {
            return false;
        }
        if (aRowIndex - aColIndex == bRowIndex-bColIndex) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        int n = 8;
        Node root = initNodes(n);
        List<Node> children = root.children;

        for (Node node : children) {
            Set<Node> path = new HashSet<Node>();
            backtrace(node,path, n);
        }
    }

    public static void backtrace(Node node, Set<Node> path, int n){
        if (compatible(node, path, n)) {
            path.add(node);
        } else {
            return;
        }
        List<Node> children = node.children;
        if (children.size()!=0) {
            for (Node child : children) {
                backtrace(child,path,n);
            }
        } else {
            for (Node p : path) {
                System.out.print(getColIndex(p, n)+" ");
            }
            System.out.println();
        }

        /*if (children.size() != 0) {
            for (Node child : children) {

            }
        } else {
            path.remove();
        }*/
    }
}

class Node {
    public int val;
    public List<Node> children;

    @Override
    public String toString() {
        return "{val:" + val + ",children:" + listToStr() + "}";
    }

    public String listToStr() {
        if (children == null || children.size() == 0) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder("[");
            for (Node node : children) {
                builder.append(node.val + ",");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            return builder.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }
        return ((Node) o).val == val && childrenEquality(((Node) o).children, children);
    }

    private boolean childrenEquality(List<Node> c1, List<Node> c2) {
        if (c1 == c2) {
            return true;
        } else {
            if ((c1 == null && c2 != null) || (c2 == null && c1 != null)) {
                return false;
            } else {
                if (c1.size() != c2.size()) {
                    return false;
                } else {
                    for (int i = 0; i < c1.size(); i++) {
                        if (!c1.get(i).equals(c2.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }
}
