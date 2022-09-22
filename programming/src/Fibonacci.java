public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        // int r = new Fibonacci().fib(5);
        int r = new Fibonacci().fib(n, f);
        System.out.println(r);
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }
    }

    int fib(int n) {
        if (n < 2) {
            return n;

        }
        return fib(n - 1) + fib(n - 2);
    }

    // i= 0, 1, 2
    int fib(int n, int[] source) {
        if (n < 2) {
            return n;
        }
        if (source[n] != 0) {
            return source[n];
        }
        source[n] = fib(n - 1, source) + fib(n - 2, source);
        return source[n];
    }

    // i= 0, 1, 2
    int fibr(int n) {
        if (n < 2) {
            return n;
        }        
        return fibr(n - 1) + fibr(n - 2);        
    }
}
