import java.util.Scanner;

public class DAA002 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static short getSum(int n) {
        short sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static int getNextNumber(int n, short k) {
        for (int i = n + 1; i <= 100000 + n; i++) {
            if (getSum(i) == k) { return i; }
        }

        return -1;
    }

    public static void main(String[] args) {
        short T = inputScanner.nextShort();

        for (short i = 0; i < T; i++) {
            int n = inputScanner.nextInt();
            short k = inputScanner.nextShort();

            System.out.println(getNextNumber(n, k));
        }
    }
}