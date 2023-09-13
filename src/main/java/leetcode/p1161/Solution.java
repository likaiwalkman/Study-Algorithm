package leetcode.p1161;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maxLevelSum(TreeNode root) {
        List<TreeNode> seeds = new ArrayList<>();
        seeds.add(root);

        int layer = 0;
        int resultLayer = 0;
        int maxSum = Integer.MIN_VALUE;
        while (!seeds.isEmpty()){
            layer++;

            List<TreeNode> newseeds = new ArrayList<>();
            int sum = 0;
            for (TreeNode seed : seeds) {
                sum += seed.val;
                if (seed.left != null) {
                    newseeds.add(seed.left);
                }
                if (seed.right != null) {
                    newseeds.add(seed.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                resultLayer = layer;
            }
            seeds = newseeds;
        }
        return resultLayer;
    }

}
