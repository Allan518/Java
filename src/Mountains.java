import java.io.PrintStream;
import java.util.Scanner;

public class Mountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        PrintStream ps = new PrintStream(System.out);
        for (int i = 0; i < q; i++) {
            int mountain = sc.nextInt() - 1;
            int height = sc.nextInt();
            heights[mountain] += height;
            ps.println(getPairs(heights));
        }

    }

    public static int getPairs(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (j == i + 1) {
                    res++;
                } else {
                    boolean valid = true;
                    for (int k = i + 1; k < j; k++) {
                        if (!isValid(i, k, j, heights[i], heights[k], heights[j])) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValid(int a, int b, int c, int heightA, int heightB, int heightC) {
        double slope = (double) (heightC - heightA) / (c - a);
        if (heightB > heightA + slope * (b - a)) {
            return false;
        }
        return true;
    }
}
