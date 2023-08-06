package leetcode.p167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while (j > i){
            if (numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            }else if (numbers[i] + numbers[j] > target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{0, 0};
    }
}
