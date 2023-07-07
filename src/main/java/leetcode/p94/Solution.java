package leetcode.p94;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        iter(root, result);
        return result;
    }

    public void iter(TreeNode treeNode, List<Integer> result){
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            iter(treeNode.left, result);
        }
        result.add(treeNode.val);
        if (treeNode.right!= null){
            iter(treeNode.right, result);
        }
    }
}
