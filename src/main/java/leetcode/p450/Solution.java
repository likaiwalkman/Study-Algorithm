package leetcode.p450;

import leetcode.common.TreeNode;

public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode originalRoot = root;

        TreeNode targetParent = null;
        TreeNode target = null;

        while (root != null) {
            if (root.val == key) {
                target = root;
            }else {
                targetParent = root;
                if (key < root.val) {
                    root = root.left;
                }else {
                    root = root.right;
                }
            }
        }

        if (target == null){
            return originalRoot;
        }

        TreeNode targetRightMostLeft = null;
        TreeNode targetRightMostLeftParent = target.right;
        if (targetRightMostLeftParent != null && targetRightMostLeftParent.left != null){
            targetRightMostLeft = targetRightMostLeftParent.left;
            while (targetRightMostLeft != null) {
                // targetRightMostLeftParent = targetRightMostLeftParent;
                targetRightMostLeft = targetRightMostLeftParent.left;
            }
        }


        if (targetParent == null) {
            if (target.left == null && target.right == null) {
                return null;
            }else if (target.left == null && target.right != null) {
                return originalRoot.right;
            }else if (target.left != null && target.right == null) {
                return originalRoot.left;
            }else {
                if (targetRightMostLeft == null) {
                    target.right.left = target.left;
                    return target.right;
                }else {
                    targetRightMostLeftParent.left = null;
                    targetRightMostLeftParent.right = target;
                    targetRightMostLeft.left = target.left;
                    return targetRightMostLeft;
                }
            }
        }else {
            if (target.left == null && target.right == null) {
                if (targetParent.left == target) {
                    targetParent.left = null;
                }else {
                    targetParent.right = null;
                }
                return originalRoot;
            }else if (target.left == null && target.right != null) {
                if (targetParent.left == target) {
                    targetParent.left = target.right;
                }else {
                    targetParent.right = target.right;
                }
                return originalRoot.right;
            }else if (target.left != null && target.right == null) {
                if (targetParent.left == target) {
                    targetParent.left = target.left;
                }else {
                    targetParent.right = target.left;
                }
                return originalRoot.left;
            }else {
                if (targetRightMostLeft == null) {
                    target.right.left = target.left;
                    if (targetParent.left == target) {
                        targetParent.left = target.right;
                    }else {
                        targetParent.right = target.right;
                    }
                    return originalRoot;
                }else {
                    targetRightMostLeftParent.left = null;
                    targetRightMostLeftParent.right = target;
                    targetRightMostLeft.left = target.left;

                    if (targetParent.left == target) {
                        targetParent.left = targetRightMostLeft;
                    }else {
                        targetParent.right = targetRightMostLeft;
                    }
                    return originalRoot;
                }
            }
        }





    }
}
