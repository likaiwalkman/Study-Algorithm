package leetcode.p103;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> seeds = new ArrayList<>();
        seeds.add(root);
        boolean leftToRight = true;

        while (!seeds.isEmpty()){
            List<Integer> group = new ArrayList<>();
            if (leftToRight) {
                for (int i = 0; i < seeds.size(); i++) {
                    group.add(seeds.get(i).val);
                }
            }else {
                for (int i = seeds.size()-1; i >= 0; i--) {
                    group.add(seeds.get(i).val);
                }
            }
            result.add(group);

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

            leftToRight = !leftToRight;
        }
        return result;
    }
}
