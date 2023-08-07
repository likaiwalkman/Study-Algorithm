package leetcode.p114;

import leetcode.common.TreeNode;

import java.util.Stack;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode lastVisitNode = null;
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();

            if (pop.right != null){
                stack.push(pop.right);
                pop.right = null;
            }
            if (pop.left != null) {
                stack.push(pop.left);
                pop.left = null;
            }
            if (lastVisitNode != null) {
                lastVisitNode.right = pop;
            }
            lastVisitNode = pop;
        }
    }
}
