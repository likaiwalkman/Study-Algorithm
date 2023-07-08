package leetcode.p93;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        List<int[]> segments = new ArrayList<>();

        iter(results, segments, s);

        return results;

    }
    public void iter(List<String> results, List<int[]> segments, String s){

        if (segments.size() > 0){
            int[] ints = segments.get(segments.size() - 1);

            String substring = s.substring(ints[0], ints[1] + 1);
            if (substring.length() > 1 && substring.startsWith("0")) {
                return;
            }
            if (Integer.parseInt(substring) > 255) {
                return;
            }

            int maxOffset = ints[1];
            if (segments.size() < 4 && maxOffset == s.length()-1) {
                return;
            }
            if (segments.size() == 4 && maxOffset < s.length()-1) {
                return;
            }

            if (segments.size() == 4 && maxOffset == s.length()-1) {
                StringBuilder builder = new StringBuilder();
                int count = 0;
                for (int[] segment : segments) {
                    String str = s.substring(segment[0], segment[1] + 1);
                    if(count++ < 3){
                        builder.append(str+".");
                    }else {
                        builder.append(str);
                    }
                }
                results.add(builder.toString());
            }


        }

        if (segments.size() == 0) {
            for (int i = 0; i < 3 && i < s.length(); i++) {
                int[] arr = new int[]{0, i};
                segments.add(arr);
                iter(results, segments, s);
                segments.remove(segments.size()-1);
            }
        }else {
            int[] ints = segments.get(segments.size() - 1);
            int maxOffset = ints[1];

            for (int i = maxOffset+1; i < s.length() && i < maxOffset+4; i++) {
                int[] arr = new int[]{maxOffset+1, i};
                segments.add(arr);
                iter(results, segments, s);
                segments.remove(segments.size()-1);
            }
        }
    }
}
