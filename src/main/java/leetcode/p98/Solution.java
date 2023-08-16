package leetcode.p98;

import leetcode.common.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }
        Integer previousValue = null;
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            int v = pop.val;
            if (previousValue != null && previousValue >= v) {
                return false;
            }
            previousValue = v;
            root = pop.right;
            while (root != null){
                stack.push(root);
                root = root.left;
            }
        }
        return true;
    }
}
