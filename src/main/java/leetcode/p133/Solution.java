package leetcode.p133;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        IdentityHashMap<Node, Node> nodeMap = new IdentityHashMap<>();
        Node newNode = clone(node, nodeMap);
        return newNode;
    }

    private Node clone(Node node, IdentityHashMap<Node, Node> nodeMap){
        Node newNode = nodeMap.get(node);
        if (newNode != null) {
            return newNode;
        }
        newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            Node correspondingNeighbor = clone(neighbor, nodeMap);
            newNode.neighbors.add(correspondingNeighbor);
        }
        return newNode;
    }
}
