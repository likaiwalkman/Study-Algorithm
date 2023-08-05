package leetcode.p199;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<TreeNode> seeds = new ArrayList<>();
        seeds.add(root);

        List<Integer> result = new ArrayList<>();
        while (seeds.size() > 0) {
            result.add(seeds.get(0).val);

            List<TreeNode> nextLayerSeeds = new ArrayList<>();
            for (TreeNode seed : seeds) {
                if (seed.right != null){
                    nextLayerSeeds.add(seed.right);
                }
                if (seed.left != null){
                    nextLayerSeeds.add(seed.left);
                }
            }
            seeds = nextLayerSeeds;
        }
        return result;
    }
}
