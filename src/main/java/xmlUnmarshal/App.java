package xmlUnmarshal;

public class App {
    public void sort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < num){
                    num = arr[j];
                    index = j;
                }
            }
            if (index != i){
                swap(arr, i, index);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int binarySortedFind(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int i = 0;
        int j = arr.length-1;

        return binarySortedFind(arr, target, i, j);
    }

    private int binarySortedFind(int[] arr, int target, int from, int end){
        if (target < arr[from] || target > arr[end]  ) {
            return -1;
        }
        if (arr[from] == target){
            return from;
        }
        if (arr[end] == target){
            return end;
        }
        if (from == end){
            return -1;
        }else{
            int mid = (from + end) / 2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return binarySortedFind(arr,  target,from, mid);
            }else {
                return binarySortedFind(arr,  target,mid+1, end);
            }
        }
    }

}
