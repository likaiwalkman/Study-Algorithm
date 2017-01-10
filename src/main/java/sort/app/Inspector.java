package sort.app;

import sort.dualPivotQuickSort.DualPivotQuicksort;
import sort.timesort.ComparableTimSort;

import java.util.Arrays;

public class Inspector {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 2, 3};
        DualPivotQuicksort.sort(arr);
        System.out.println(Arrays.toString(arr));
        String[] ls = {"4", "1", "5", "2", "3"};
        ComparableTimSort.sort(ls);
        System.out.println(Arrays.toString(ls));
    }
}
