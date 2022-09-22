public class Spiral {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = new Spiral().spiral(n);
        new Spiral().printArray(a, n, n);
    }

    int[][] spiral(int n) {
        int mid = (n + 1) / 2;
        int index = 0;
        int[][] a = new int[n][n];
        for (int k = 0; k < mid; k++) {
            int f = k;
            for (int c = k; c < n - k ; c++) {
                a[f][c] = index;
                index++;
            }
            int c = n - k - 1;
            for (f = k + 1; f < n - k ; f++) {
                a[f][c] = index;
                index++;
            }
            f = n - k - 1;
            for (c = n - k - 2; c > k -1; c--) {
                a[f][c] = index; 
                index++;
            }
            c = k;
            for (f = n - k - 2; f > k; f--) {
                a[f][c] = index;
                index++;
            }
        }
        return a;
    }

    void printArray(int[][] a, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t"+ a[i][j]);
            }

            System.out.println("\n");
        }
    }
}
