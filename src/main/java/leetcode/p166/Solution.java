package leetcode.p166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;

        if (numeratorLong == 0){
            return "0";
        }

        boolean positive = false;
        if (numeratorLong > 0 && denominatorLong > 0){
            positive = true;
        }

        if (numeratorLong < 0 && denominatorLong < 0){
            positive = true;
        }


        long integratedPart = numeratorLong / denominatorLong;
        long remain = Math.abs(numeratorLong % denominatorLong);
        denominatorLong = Math.abs(denominatorLong);
        if (remain == 0){
            return String.valueOf(integratedPart);
        }
        Map<Long, Integer> map = new HashMap<>();
        List<Character> fractions = new ArrayList<>();
        remain *= 10;

        while (true){
            if (remain == 0){
                StringBuilder builder = new StringBuilder();
                for (Character fraction : fractions) {
                    builder.append(fraction);
                }
                String result = integratedPart + "." + builder.toString();
                return !positive && !result.startsWith("-") ? "-"+result : result;
            }
            if (map.containsKey(remain)) {
                Integer i = map.get(remain);
                StringBuilder builder = new StringBuilder();
                for (int j = i; j < fractions.size(); j++) {
                    builder.append(fractions.get(j));
                }

                StringBuilder prebuilder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    prebuilder.append(fractions.get(j));
                }
                String result = integratedPart+"."+prebuilder.toString()+"("+builder.toString()+")";
                return !positive && !result.startsWith("-") ? "-"+result : result;
            }
            if (remain < denominatorLong) {
                fractions.add('0');
                map.put(remain, fractions.size()-1);

                remain *= 10;
            }else {
                long l = remain / denominatorLong;
                fractions.add((char)('0'+l));
                map.put(remain, fractions.size()-1);

                remain = remain % denominatorLong;
                remain *= 10;
            }
        }
    }
}
