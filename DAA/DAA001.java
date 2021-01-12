/* 
#bits in short = 16 
range = [ - 2 ^ 15, 2 ^ 15 - 1 ]
range = [ -32768, 32767 ]

#bits in int = 32
range = [ - 2 ^ 31, 2 ^ 31 - 1 ]
range = [ -2147483648, 2147483647 ]
*/

import java.util.Scanner;

public class DAA001 {
    final static Scanner inputScanner = new Scanner(System.in);
    final static int key = 42;

    public static short linearCount(int[] S, short N) {
        short count = 0;

        for (short i = 0; i < N; i++) {
            if (S[i] == key) { count++; }
        }

        return count;
    }

    public static void main(String[] args) {
        short N = inputScanner.nextShort();
        int[] S = new int[N];

        for (short i = 0; i < N; i++) {
            S[i] = inputScanner.nextInt();
        }

        System.out.println(linearCount(S, N));
    }
}