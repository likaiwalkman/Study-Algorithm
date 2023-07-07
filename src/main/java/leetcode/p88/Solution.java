package leetcode.p88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        while (n > 0){
            if (m > 0) {
                if(nums2[n-1] > nums1[m-1]){
                    nums1[--total] = nums2[--n];
                }else {
                    nums1[--total] = nums1[--m];
                }
            }else {
                nums1[--total] = nums2[--n];
            }
        }
    }
}
