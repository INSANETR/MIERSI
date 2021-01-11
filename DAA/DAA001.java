import java.util.Scanner;

public class DAA001 {
    final static Scanner inputScanner = new Scanner(System.in);
    final static int key = 42;

    public static int linearCount(int sequenceSize) {
        int count = 0;

        for (int i = 0; i < sequenceSize; i++) {
            int number = inputScanner.nextInt();

            if (number == key) { count++; }
        }

        return count;
    }

    public static void main(String[] args) {
        int sequenceSize = inputScanner.nextInt();

        System.out.println(linearCount(sequenceSize));
    }
}