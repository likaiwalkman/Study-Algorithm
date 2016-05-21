import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);

        int[] result = new int[2];
        Arrays.fill(result, 0);
        for (int num : nums) {
            if ((diff & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Long l = new Long(10);     //定义一个Long型数据

        long j = Long.highestOneBit(l);

        System.out.println(j);

        int[] arr = {1, 1, 7, 5};
        int[] ints = new Solution().singleNumber(arr);
        System.out.println(ints);
    }
}
