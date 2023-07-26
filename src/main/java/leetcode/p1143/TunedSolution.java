package leetcode.p1143;

public class TunedSolution {
    public static int[][] printMatrixStatus(String text1, String text2, int[][] array){
        
        int[][] objects = new int[text1.length()+2][text2.length()+2];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new int[text2.length()+2];
        }
        for (int i = 0; i < text2.length(); i++) {
            objects[0][i+2] = text2.charAt(i);
        }
        for (int i = 0; i < text1.length(); i++) {
            objects[i+2][0] = text1.charAt(i);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                objects[i+1][j+1] = array[i][j];
            }
        }


        for (int i = 0; i < objects[0].length; i++) {
            if (i < objects[0].length-1) {
                System.out.print((char) objects[0][i] + "\t");
            }else {
                System.out.println((char) objects[0][i]);
            }
        }

        for (int i = 1; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                if (j < objects[i].length-1) {
                    if (j == 0) {
                        System.out.print((char) objects[i][j] + "\t");
                    }else {
                        System.out.print(objects[i][j] + "\t");
                    }
                }else {
                    System.out.println(objects[i][j]);
                }
            }
        }
        return objects;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        String lcs = null;
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length()==0){
            lcs = "";
            System.out.println("lcs:"+lcs);
            return 0;
        }
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length()==0){
            return 0;
        }
        int[][] array = new int[text1.length()+1][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[text2.length()+1];
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    array[i][j] = array[i-1][j-1] + 1;
                }else {
                    if (array[i-1][j] > array[i][j-1]) {
                        array[i][j] = array[i-1][j];
                    }else {
                        array[i][j] = array[i][j-1];
                    }
                }
            }

        }
        printMatrixStatus(text1, text2, array);
        String extracted = extracted(text1, text2, array);
        System.out.println("result string:"+extracted);
        return array[text1.length()][text2.length()];
    }

    private static String extracted(String text1, String text2, int[][] array) {
        StringBuilder builder = new StringBuilder();
        int m = text1.length();
        int n = text2.length();
        int count = array[m][n];
        if (count != 0) {
            while (m >= 1 && n >= 1 && count > 0){
                int m0 = m;
                while (m0-1 >= 1 && array[m0-1][n] == array[m][n]){
                    m0--;
                }
                m=m0;

                int n0 = n;
                while (n0-1 >= 1 && array[m][n0-1] == array[m][n]){
                    n0--;
                }
                n = n0;

                count--;
                char commonChar = text1.charAt(m - 1);
                builder.append(commonChar);
                n--;
            }
            String s = builder.reverse().toString();
            return s;
        }
        return "";
    }


}
