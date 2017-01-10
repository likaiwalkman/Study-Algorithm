package sort.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JdkSortInspect {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 2, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List<String> ls = new ArrayList<String>();
        ls.add("4");
        ls.add("1");
        ls.add("5");
        ls.add("2");
        ls.add("3");
        Collections.sort(ls);
        System.out.println(ls);
    }
}
