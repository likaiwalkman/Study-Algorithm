package sort.app;

import sort.dualPivotQuickSort.DPQuicksort;

import java.util.Arrays;

public class DPQuicksortInspect {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 2, 3};
        DPQuicksort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
