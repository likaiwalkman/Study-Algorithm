package leetcode.p111;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        int layerCount = 0;
        while (!list.isEmpty()){
            List<TreeNode> newList = new ArrayList<>();
            layerCount++;
            for (TreeNode treeNode : list) {
                if (treeNode.left == null && treeNode.right == null) {
                    return layerCount;
                }
                if (treeNode.left != null) {
                    newList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    newList.add(treeNode.right);
                }
            }
            list = newList;
        }
        return 0;
    }
}
