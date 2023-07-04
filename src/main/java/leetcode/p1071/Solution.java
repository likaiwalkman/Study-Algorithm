package leetcode.p1071;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()){
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }
        String target = "";
        for (int i = str2.length(); i >= 1; i--) {
            if (str2.length() % i != 0 || str1.length() % i != 0) {
                continue;
            }

            String template = str2.substring(0, i);
            if (!valid(str2, i, template)) {
                continue;
            }

            if (!valid(str1, i, template)) {
                continue;
            }

            target = template;
            break;
        }

        return target;
    }

    public boolean valid(String str, int n, String template){
        int times = str.length() / n;
        for (int j = 0; j < times; j++) {
            for (int k = 0; k < n; k++) {
                if (template.charAt(k) != str.charAt(j*n+k)) {
                    return false;
                }
            }
        }
        return true;
    }
}
