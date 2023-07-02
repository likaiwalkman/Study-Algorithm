package leetcode.p12;

public class Solution {
    public String intToRoman(int num) {
        int[] weights = new int[]{
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1
        };
        String[] romas = new String[]{
                "M",
                "CM",
                "D",
                "CD",
                "C",
                "XC",
                "L",
                "XL",
                "X",
                "IX",
                "V",
                "IV",
                "I"
        };
        String result = "";
        while (num != 0){
            int found = -1;
            for (int k = 0; k < weights.length; k++){
                if (num >= weights[k]) {
                    result += romas[k];
                    num -= weights[k];
                    break;
                }
            }
        }
        return result;
    }
}
