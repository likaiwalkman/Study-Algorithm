package leetcode.p97;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1 == null ? 0 : s1.length();
        int s2Len = s2 == null ? 0 : s2.length();
        int s3Len = s3 == null ? 0 : s3.length();

        if (s1Len + s2Len != s3Len){
            return false;
        }

        if (s3Len == 0){
            return true;
        }

        if (s1 == null) {
            s1 = "";
        }
        if (s2 == null) {
            s2 = "";
        }


        List<int[]> list = new ArrayList<>();

        if (!s1.isEmpty()) {
            if (s1.charAt(0) == s3.charAt(0)) {
                list.add(new int[]{0, -1, 0});
            }
        }
        if (!s2.isEmpty()) {
            if (s2.charAt(0) == s3.charAt(0)) {
                list.add(new int[]{-1, 0, 1});
            }
        }
        if (list.isEmpty()){
            return false;
        }
        for (int i = 1; i < s3.length(); i++) {
            List<int[]> newList = new ArrayList<>();
            for (int[] ints : list) {
                if (ints[2] == 0) {
                    if (ints[1] + 1 < s2.length() && s2.charAt(ints[1] + 1) == s3.charAt(i)) {
                        int[] pos = {ints[0], ints[1] + 1, 1};
                        newList.add(pos);
                    }
                    if (ints[0] + 1 < s1.length() && s1.charAt(ints[0] + 1) == s3.charAt(i)) {
                        int[] pos = {ints[0] + 1, ints[1], 0};
                        newList.add(pos);
                    }
                } else {
                    if (ints[0] + 1 < s1.length() && s1.charAt(ints[0] + 1) == s3.charAt(i)) {
                        int[] pos = {ints[0] + 1, ints[1], 1};
                        newList.add(pos);
                    }
                    if (ints[1] + 1 < s2.length() && s2.charAt(ints[1] + 1) == s3.charAt(i)) {
                        int[] pos = {ints[0], ints[1] + 1, 1};
                        newList.add(pos);
                    }
                }
            }
            list = newList;
            if (list.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
