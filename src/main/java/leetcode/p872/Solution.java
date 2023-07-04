package leetcode.p872;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2){
            return true;
        }
        if (root1 != null && root2 == null){
            return false;
        }else if(root1 == null && root2 != null){
            return false;
        }
        List<Integer> leave1 = new ArrayList<>();
        List<Integer> leave2 = new ArrayList<>();
        leaves(root1, leave1);
        leaves(root2, leave2);

        if (leave1.size() != leave2.size()) {
            return false;
        }
        for (int i = 0; i < leave1.size(); i++) {
            if (leave1.get(i) != leave2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void leaves(TreeNode root, List<Integer> leaves){
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        if (root.left != null) {
            leaves(root.left, leaves);
        }
        if (root.right != null){
            leaves(root.right, leaves);
        }

    }
}
