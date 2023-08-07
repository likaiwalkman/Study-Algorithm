package leetcode.p222;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> seeds = new ArrayList<>();
        seeds.add(root);
        int count = 0;
        while (!seeds.isEmpty()){
            count += seeds.size();
            List<TreeNode> newSeeds = new ArrayList<>();
            for (TreeNode seed : seeds) {
                if (seed.left != null) {
                    newSeeds.add(seed.left);
                }
                if (seed.right != null) {
                    newSeeds.add(seed.right);
                }
            }
            seeds = newSeeds;
        }
        return count;
    }
}
