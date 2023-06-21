package leetcode.p2471;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> prevLayerNodes = new ArrayList<>();
        prevLayerNodes.add(root);

        int totalOperations = 0;
        while (prevLayerNodes.size() > 0) {
            List<Integer> integers = new ArrayList<>();
            for (TreeNode prevLayerNode : prevLayerNodes) {
                integers.add(prevLayerNode.val);
            }
            int layerOperationCnt = layerOperationCount(integers);
            totalOperations += layerOperationCnt;

            //update next loop data
            List<TreeNode> nextLayerNodes = new ArrayList<>();
            for (TreeNode prevLayerNode : prevLayerNodes) {
                if (prevLayerNode.left != null) {
                    nextLayerNodes.add(prevLayerNode.left);
                }
                if (prevLayerNode.right != null) {
                    nextLayerNodes.add(prevLayerNode.right);
                }
            }
            prevLayerNodes = nextLayerNodes;
        }
        return totalOperations;
    }

    public int layerOperationCount(List<Integer> nodes) {
        if (nodes.size() < 2) {
            return 0;
        }

        int[] indexToValueArr = new int[nodes.size()];
        //int[] bucket = new int[100001];
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            int val = nodes.get(i);
            indexToValueArr[i] = val;
            valueToIndexMap.put(val, i);
            heap.offer(val);
        }

        Map<Integer, Integer> orderedValueToSeq = new HashMap<>();
        int seq = 0;
        while (!heap.isEmpty()) {
            int min = heap.poll();
            orderedValueToSeq.put(min, seq++);
        }

        Map<Integer, Integer> orderedSeqToVal = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : orderedValueToSeq.entrySet()) {
            orderedSeqToVal.put(entry.getValue(), entry.getKey());
        }

        int layerCnt = 0;
        for (int i = 0; i < indexToValueArr.length; i++) {
            int rightValue = orderedSeqToVal.get(i);
            Integer rightValueOldIndex = valueToIndexMap.get(rightValue);
            int factualValue = indexToValueArr[i];
            if (factualValue > rightValue) {
                indexToValueArr[rightValueOldIndex] = indexToValueArr[i];
                valueToIndexMap.put(indexToValueArr[i], rightValueOldIndex);
                layerCnt++;
            }
        }

        return layerCnt;
    }
}
