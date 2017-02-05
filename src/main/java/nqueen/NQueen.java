package nqueen;

public class NQueen {
    static int NQUEEN = 8;
    final static int SIZE = NQUEEN;
    static int COUNT = 0;
    static int[] cols = new int[SIZE] ;

    public static void place(int n) {
        for (int i = 0; i < SIZE; i++) {
            boolean compatible = compatible(n, i);
            if (compatible) {
                cols[n] = i;
                if (n == SIZE - 1) {
                    printSolution();
                    COUNT ++;
                    return;
                } else {
                    place(n + 1);
                }
            } else {
                continue;
            }
        }
    }

    public static void printSolution() {
        for (int col : cols) {
            System.out.print(col);
        }
        System.out.println();
        return;
    }

    public static boolean compatible(int rowIndex, int val) {
        for (int i = 0; i < rowIndex; i++) {
            if (cols[i] == val) {
                return false;
            }
            if (rowIndex - i == val - cols[i] ) {
                return false;
            }
            if (rowIndex - i == cols[i] - val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        place(0);
        System.out.println(COUNT);
    }
}
