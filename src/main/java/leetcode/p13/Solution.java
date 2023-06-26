package leetcode.p13;

public class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'I':
                    if (i+1 < s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                        if (s.charAt(i+1) == 'V'){
                            total+=4;
                            i++;
                        }else if (s.charAt(i+1) == 'X'){
                            total+=9;
                            i++;
                        }
                    }else {
                        total += 1;
                    }
                    break;
                case 'X':
                    if (i+1 < s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                        if (s.charAt(i+1) == 'L'){
                            total+=40;
                            i++;
                        }else if (s.charAt(i+1) == 'C'){
                            total+=90;
                            i++;
                        }
                    }else {
                        total += 10;
                    }
                    break;
                case 'C':
                    if (i+1 < s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                        if (s.charAt(i+1) == 'D'){
                            total+=400;
                            i++;
                        }else if (s.charAt(i+1) == 'M'){
                            total+=900;
                            i++;
                        }
                    }else {
                        total += 100;
                    }
                    break;
                case 'L': total+=50;break;
                case 'V': total+=5;break;
                case 'D': total+=500;break;
                case 'M': total+=1000;break;
                default:
                    break;

            }
        }
        return total;
    }
}
