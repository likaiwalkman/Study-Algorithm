package leetcode.p81;

public class Solution {
    public boolean search(int[] nums, int target) {
        return nonSortSearch(nums, target, 0, nums.length - 1);
    }

    private boolean nonSortSearch(int[] nums, int target, int from, int to){
        if (from == to) {
            return nums[from] == target;
        }else {
            int mid = (from+to) / 2;
            int[] arr = new int[]{from, mid, mid+1, to};
            for (int i = 0; i < arr.length; i++) {
                if (nums[arr[i]] == target) {
                    return true;
                }
            }

            boolean former = nums[from] <= nums[(from + mid)/2] && nums[(from + mid)/2] <= nums[mid];
            boolean later = nums[mid+1] <= nums[(to + mid)/2] && nums[(to + mid)/2] <= nums[to];

            if (former && !later) {
                boolean f = sortSearch(nums, target, from, mid);
                if (f){
                    return true;
                }else {
                    return nonSortSearch(nums, target, mid+1, to);
                }
            }else if(!former && later){
                boolean f = sortSearch(nums, target, mid+1, to);
                if (f){
                    return true;
                }else {
                    return nonSortSearch(nums, target, from, mid);
                }
            }else {
                boolean b = nonSortSearch(nums, target, from, mid);
                if(b){
                    return true;
                }else {
                    return nonSortSearch(nums, target, mid+1, to);
                }
            }
        }
    }

    private boolean sortSearch(int[] nums, int target, int from, int to){
        if (from == 50 && to ==99){
            System.out.println();
        }
        if (from == to) {
            return nums[from] == target;
        }else {
            if (nums[from] > target || nums[to] < target){
                return false;
            }
            int mid = (from+to) / 2;
            int[] arr = new int[]{from, mid, mid+1, to};
            for (int i = 0; i < arr.length; i++) {
                if (nums[arr[i]] == target) {
                    return true;
                }
            }
            if (nums[mid] < target && target < nums[mid+1] ){
                return false;
            }
            if (target < nums[mid]){
                return sortSearch(nums, target, from, mid);
            }
            return sortSearch(nums, target, mid+1, to);
        }
    }
}
