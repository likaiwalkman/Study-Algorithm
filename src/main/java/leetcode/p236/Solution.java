package leetcode.p236;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancestorsOfNodeP = new ArrayList<>();
        ancestorsOfNodeP.add(root);
        iter(root, p, ancestorsOfNodeP);

        List<TreeNode> ancestorsOfNodeQ = new ArrayList<>();
        ancestorsOfNodeQ.add(root);
        iter(root, q, ancestorsOfNodeQ);

        int min = Math.min(ancestorsOfNodeP.size(), ancestorsOfNodeQ.size());
        int count = 0;
        TreeNode lowestCommonAncestor = null;
        while (count < min && ancestorsOfNodeP.get(count) == ancestorsOfNodeQ.get(count)){
            lowestCommonAncestor = ancestorsOfNodeP.get(count);
            count++;
        }
        return lowestCommonAncestor;

    }

    private void iter(TreeNode node, TreeNode target, List<TreeNode> ancestors){
        if (ancestors.get(ancestors.size()-1) == target) {
            return;
        }
        if (node.left != null) {
            ancestors.add(node.left);
            iter(node.left, target, ancestors);
            if (ancestors.get(ancestors.size()-1) != target) {
                ancestors.remove(ancestors.size()-1);
            }
        }
        if (node.right != null) {
            ancestors.add(node.right);
            iter(node.right, target, ancestors);
            if (ancestors.get(ancestors.size()-1) != target) {
                ancestors.remove(ancestors.size()-1);
            }
        }
    }
}
