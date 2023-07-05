package leetcode.p105;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i : preorder) {
            preorderList.add(i);
        }
        for (int i : inorder) {
            inorderList.add(i);
        }
        TreeNode treeNode = buildTree(preorderList, inorderList);
        return treeNode;
    }

    TreeNode buildTree(List<Integer> preorderList, List<Integer> inorderList){
        if (preorderList == null || preorderList.size() == 0){
            return null;
        }
        TreeNode rootNode = new TreeNode(preorderList.get(0));
        if (preorderList.size() == 1){
            return rootNode;
        }

        int rootVal = preorderList.get(0);
        preorderList.remove(0);

        List<Integer> lpreorderList = new ArrayList<>();
        List<Integer> linorderList = new ArrayList<>();

        List<Integer> rpreorderList = new ArrayList<>();
        List<Integer> rinorderList = new ArrayList<>();
        Iterator<Integer> iterator = inorderList.iterator();
        int flip = -1;
        int lcnt = 0;
        while (iterator.hasNext()) {
            Integer v = iterator.next();
            if (flip == 0){
                flip = 1;
            }
            if (v == rootVal) {
                flip = 0;
            }

            if (flip == -1) {
                linorderList.add(v);
                lcnt++;
            }else if (flip == 1){
                rinorderList.add(v);
            }
        }

        Iterator<Integer> iter = preorderList.iterator();
        while (iter.hasNext()) {
            Integer v = iter.next();
            if (lcnt-- > 0) {
                lpreorderList.add(v);
                continue;
            }

            rpreorderList.add(v);
        }

        TreeNode leftNode = buildTree(lpreorderList, linorderList);
        TreeNode rightNode = buildTree(rpreorderList, rinorderList);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
}
