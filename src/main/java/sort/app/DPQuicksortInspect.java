package sort.app;

import sort.dualPivotQuickSort.DPQuicksort;

import java.util.Arrays;
import java.util.Random;

public class DPQuicksortInspect {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(new Random().nextInt(30));
            System.out.print(",");
        }
        int[] arr1 = {4, 1, 5, 2, 3};
        int[] arr2 = {28,4,19,3,26,12,13,24,18,9,14,1,23,17,8,5,7,27,15,6,18,23,21,11,29,25,16,20,2,10};
        DPQuicksort.sort(arr1);
        DPQuicksort.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
