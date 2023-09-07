package leetcode.p95;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftLeaves = generateTrees(start, i-1);
            List<TreeNode> rightLeaves = generateTrees(i+1, end);
            for (TreeNode leftLeaf : leftLeaves) {
                for (TreeNode rightLeaf : rightLeaves) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftLeaf;
                    root.right = rightLeaf;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
