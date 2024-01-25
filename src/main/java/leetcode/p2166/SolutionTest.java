package leetcode.p2166;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test01() {
        for (int i = 1; i <= 17; i++) {
            System.out.println();
            System.out.println("=========fix: length: "+i+"===========");
            Bitset bitmap = new Bitset(i);
            for (int j = 0; j < i; j++) {
                bitmap.fix(j);
                bitmap.flip();
                String f1 = bitmap.toString();
                bitmap.flip();
                String f2 = bitmap.toString();
                System.out.println(f2+"->"+f1);
            }
            System.out.println("=========unfix: length: "+i+"===========");
            for (int j = 0; j < i; j++) {
                bitmap.unfix(j);
                System.out.println(bitmap.toString());
            }
        }
    }
}
