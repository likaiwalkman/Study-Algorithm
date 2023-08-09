package leetcode.p230;

import leetcode.common.TreeNode;

import java.util.IdentityHashMap;
import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> assistantStack = new Stack<>();
        IdentityHashMap<TreeNode, Boolean> visitedMap = new IdentityHashMap<>();
        int count = 0;
        assistantStack.push(root);

        while (!assistantStack.isEmpty()){
            TreeNode top = assistantStack.pop();
            if (visitedMap.containsKey(top)) {
                continue;
            }
            TreeNode unvisitedTopRight = null;
            TreeNode unvisitedTopLeft = null;
            if (top.right != null && !visitedMap.containsKey(top.right)) {
                unvisitedTopRight = top.right;
            }
            if (top.left != null && !visitedMap.containsKey(top.left)) {
                unvisitedTopLeft = top.left;
            }
            if (unvisitedTopLeft == null) {
                visitedMap.put(top, true);
                if (top.right != null && !visitedMap.containsKey(top.right)) {
                    assistantStack.push(top.right);
                }
                if (++count == k) {
                    return top.val;
                }
            }else {
                if (unvisitedTopRight != null) {
                    assistantStack.push(unvisitedTopRight);
                }
                assistantStack.push(top);
                assistantStack.push(unvisitedTopLeft);
            }
        }
        return 0;
    }
}
