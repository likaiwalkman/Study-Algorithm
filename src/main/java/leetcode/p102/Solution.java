package leetcode.p102;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (nodes.size() > 0){
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                list.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            result.add(list);
            nodes = temp;
        }

        return result;
    }
}
