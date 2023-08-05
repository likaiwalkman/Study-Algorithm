package leetcode.p135;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int length = ratings.length;
        int[] candies = new int[length];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }

        for (int i = length-2; i >=0 ; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1]+1;
            }
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }

    static boolean printlog = true;

    public int candy2(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < ratings.length; ) {
            int mode = 0;
            int j = i;
            if (i+1 < ratings.length){
                j = i+1;
                mode = markMode(ratings[i], ratings[i+1]);
                while (j + 1 < ratings.length && markMode(ratings[j], ratings[j + 1]) == mode) {
                    j++;
                }
            }
            inpsect(ratings, i, j, mode);

            lists.add(new int[]{i, j, mode});
            i = j+1;
        }

        Iterator<int[]> iterator = lists.iterator();

        int prevMode = 0;
        int[] prev = null;
        int sum = 0;
        while (iterator.hasNext()) {
            int[] current = iterator.next();
            int currentMode = current[2];
            int len = current[1] - current[0] + 1;
            int accumulated = 0;

            if (len == 1) {
                if (prev == null){
                    accumulated += 1;
                }else {
                    accumulated ++;
                    if (prevMode == 0){
                        // 5 5 | 3
                        // 5 5 | 6
                        accumulated++;
                    }else if (prevMode == 1){
                        //do nothing
                        // 3 5 | 5
                        // 3 5 | 4
                    }else {
                        // 5 4 | 4
                        // 5 4 | 5
                        if (ratings[current[0]] > ratings[prev[1]]){
                            accumulated++;
                        }
                    }
                }
            }else {
                if (prev == null){
                    if (currentMode == 0){
                        accumulated += len;
                    }else if (currentMode == 1){
                        accumulated += len * (len+1)/2;
                    }else if (currentMode == -1){
                        accumulated += len * (len+1)/2;
                    }
                }else {
                    int oldLen =  prev[1] - prev[0] + 1;
                    if (currentMode == 0){
                        accumulated += len;

                        if (prevMode == 1){
                            // 3 5 | 5 5
                            // 7 8 | 5 5
                            //do nothing
                        }else if(prevMode == -1){
                            // 3 2 | 2       2
                            // 3 2 | 4(1->2) 4
                            if (ratings[current[0]] > ratings[prev[1]]) {
                                accumulated += 1;
                            }
                        }
                    }else if (currentMode == 1){
                        accumulated += len * (len+1)/2;
                        if (prevMode == 0){
                            if (ratings[prev[1]] < ratings[current[1]]){
                                accumulated += len;
                            }
                        }else if(prevMode == -1){
                            //do nothing
                            // 7 6 | 6 7
                            // 8 7 | 6 7
                            if (ratings[prev[1]] > ratings[current[0]]){
                                accumulated += len;
                            } else if (ratings[prev[1]] < ratings[current[0]]) {
                                accumulated += oldLen;
                            }

                        }else {
                            // 3 4 | 1 2
                            // 3 4 | 4 5
                            // 3 4 | 6 7
                            if (ratings[current[0]] > ratings[prev[1]]){
                                accumulated -= len * (len+1)/2;
                                accumulated += len * (oldLen+1+oldLen+len)/2;
                            }
                            //accumulated += len * (len+1)/2;
                        }
                    }else if (currentMode == -1){
                        accumulated += len * (len+1)/2;
                        //  6 5 | 5 3
                        if (prevMode == 1){
                            // 5 7 | 7 5
                            // 7 8 | 7 5
                            //TODO
                            if (ratings[current[0]] != ratings[prev[1]] && len >= oldLen){
                                accumulated += len+1;
                                accumulated -= oldLen;
                            }
                        }else if(prevMode == 0){
                            // 6 6 6 5
                            // 5 5 6 5
                            // 7 7 | 6 5
                            if (ratings[current[0]] < ratings[prev[1]]){
                                accumulated += len;
                            }
                        }else {
                            // 6 5 | 5 3
                            // 6 5 | 7 5
                            //do nothing
//                            if (ratings[current[0]] > ratings[prev[1]]){
//                                accumulated -= len * (len+1)/2;
//                                accumulated += len * (oldLen+1+oldLen+len)/2;
//                            }
                        }
                    }
                }
            }

            sum += accumulated;
            inspectAccumulated(ratings, current, prev, accumulated);
            System.out.println("--------------");
            //System.out.println("accumulated:"+accumulated);
            prev = current;
            prevMode = current[2];
        }
        return sum;
    }

    static int markMode(int a, int b){
        if(a == b){
            return 0;
        }else if (b > a){
            return 1;
        }else {
            return -1;
        }
    }

    static void inpsect(int ratings[], int i, int j, int mode){
        if (!printlog) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = i; k <= j; k++) {
            if (k==j){
                builder.append(""+ratings[k]);
            }else {
                builder.append(ratings[k]+",");
            }
        }
        String range = builder.toString();
        System.out.println("i="+i+",j="+j+" range:"+range+", mode="+mode);
    }

    static void inspectAccumulated(int ratings[], int[] current, int[] prev, int accumulated){
        if (!printlog) {
            return;
        }
        int i = current[0];
        int j = current[1];
        String currentRange = getRange(ratings, current);
        String prevRange = getRange(ratings, prev);

        System.out.println("i="+i+",j="+j+" CurrentRange:"+currentRange);
        System.out.println("i="+i+",j="+j+" PrevRange:"+prevRange);
        System.out.println("accumulated: "+accumulated);
    }

    static String getRange(int ratings[], int[] ints){
        if (ints == null) {
            return "";
        }
        int i = ints[0];
        int j = ints[1];
        StringBuilder builder = new StringBuilder();
        for (int k = i; k <= j; k++) {
            if (k==j){
                builder.append(""+ratings[k]);
            }else {
                builder.append(ratings[k]+",");
            }
        }
        String range = builder.toString();
        return range;
    }
}
