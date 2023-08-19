package xmlUnmarshal;

public class AppTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 1, 5};
        new App().sort(arr);
        int i = new App().binarySortedFind(arr, 4);
        System.out.println(arr);
    }
}
