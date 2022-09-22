public class Pyramid {
    public static void main(String... args) {
        
        new Pyramid().buildPyramid(3);

        new Pyramid().recursivePyramid(3, 0, "");
    }

    void buildPyramid(int n) {
        for (int i = 0; i < n; i++) {
            String line = "";
            int m = n * 2 - 1;
            for (int j = 0; j < m; j++) {
                if (j < m / 2 - i || j > m / 2 + i) {
                    line += " ";
                } else {
                    line += "#";
                }
            }
            System.out.println("\"" + line + "\"");
        }

    }

    void recursivePyramid(int n, int i, String line) {
        if (n == i) {
            return;
        }
        if (line.length() == n * 2 - 1) {
            System.out.println("\"" + line + "\"");
            recursivePyramid(n, i + 1, "");
            return;
        }
        int mid = (n * 2 - 1) / 2;
        int j = line.length();
        if (j < mid - i || j > mid + i) {
            line += " ";
        } else {
            line += "#";
        }
        recursivePyramid(n, i, line);
    }
}
