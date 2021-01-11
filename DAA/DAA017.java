import java.util.Scanner;

public class DAA017 {
    public static long countPaths(boolean[][] dArray, int N) {
        long[][] pArray = new long[N][N];

        for (int i = 0; i < N; i++) {
            pArray[N - 1][i] = 1;   
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i < N - 1 && !dArray[i + 1][j]) { pArray[i][j] += pArray[i + 1][j]; }

                if (i < N - 1 && j < N - 1 && !dArray[i + 1][j + 1]) { pArray[i][j] += pArray[i + 1][j + 1]; }
            }
        }

        if (dArray[0][0]) { return 0; }

        return pArray[0][0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        boolean[][] dArray = new boolean[N][N];

        int D = input.nextInt();

        for (int i = 0; i < D; i++) {
            int c = input.nextInt();
            int p = input.nextInt();

            dArray[(N - 1) - (c - 1)][p - 1] = true;
        }

        System.out.println(countPaths(dArray, N));
    }
}