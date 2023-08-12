package leetcode.p106;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        for (int i : inorder) {
            inorderList.add(i);
        }

        for (int i : postorder) {
            postorderList.add(i);
        }

        TreeNode treeNode = buildTree(inorderList, postorderList);
        return treeNode;
    }

    private TreeNode buildTree(List<Integer> inorderList, List<Integer> postorderList){
        if (inorderList.isEmpty()){
            return null;
        }
        Integer root = postorderList.get(postorderList.size()-1);
        TreeNode rootNode = new TreeNode(root);

        int rootIndex = inorderList.indexOf(root);
        List<Integer> subLeftInorderList  = inorderList.subList(0, rootIndex);
        List<Integer> subLeftPostorderList  = postorderList.subList(0, rootIndex);

        TreeNode leftNode = buildTree(subLeftInorderList, subLeftPostorderList);
        rootNode.left = leftNode;

        List<Integer> subRightInorderList = inorderList.subList(rootIndex+1, inorderList.size());
        List<Integer> subRightPostorderList = postorderList.subList(rootIndex, postorderList.size()-1);

        TreeNode rightNode = buildTree(subRightInorderList, subRightPostorderList);
        rootNode.right = rightNode;

        return rootNode;

    }
}
