package leetcode.p450;

import leetcode.common.TreeNode;

public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode originalRoot = root;
        TreeNode target = null;
        TreeNode targetParent = null;
        while (root != null) {
            if (root.val == key) {
                target = root;
                break;
            }else if(key > root.val ) {
                targetParent = root;
                root = root.right;
            }else {
                targetParent = root;
                root = root.left;
            }
        }

        if (target == null){
            return originalRoot;
        }

        if (target.left == null && target.right == null) {
            if (targetParent == null){
                return null;
            }else {
                if (targetParent.left == target) {
                    targetParent.left = null;
                }
                if (targetParent.right == target) {
                    targetParent.right = null;
                }
                return originalRoot;
            }
        }else if (target.left == null && target.right != null) {
            TreeNode targetRight = target.right;
            target.right = null;
            if (targetParent == null){
                return targetRight;
            }else {
                if (targetParent.left == target) {
                    targetParent.left = targetRight;
                }
                if (targetParent.right == target) {
                    targetParent.right = targetRight;
                }
                return originalRoot;
            }
        }else if (target.left != null && target.right == null) {
            TreeNode targetLeft = target.left;
            target.left = null;
            if (targetParent == null){
                return targetLeft;
            }else {
                if (targetParent.left == target) {
                    targetParent.left = targetLeft;
                }
                if (targetParent.right == target) {
                    targetParent.right = targetLeft;
                }
                return originalRoot;
            }
        }else {
            TreeNode targetLeft = target.left;
            TreeNode targetRight = target.right;
            target.left = null;

            TreeNode targetRightMostLeft = targetRight;
            while (targetRightMostLeft.left != null) {
                targetRightMostLeft = targetRightMostLeft.left;
            }
            targetRightMostLeft.left = targetLeft;

            if (targetParent == null){
                return targetRight;
            }else {
                if (targetParent.left == target) {
                    targetParent.left = targetRight;
                }else {
                    targetParent.right = targetRight;
                }
                return originalRoot;
            }
        }


    }
}
