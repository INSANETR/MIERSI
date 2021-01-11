import java.util.Scanner;

public class DAA011 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static boolean isPossible(int[] array, int maxSize, int key) {
        int partitions = 1;
        int size = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxSize) { return false; }

            if (array[i] + size > maxSize) {
                partitions++;
                size = 0;
            }

            size += array[i];
        }

        if (partitions > key) { return false; }

        return true;
    }

    public static int binarySearch(int[] array, int low, int high, int key) {
        while (low < high) {
            int middle = low + (high - low) / 2;

            if (isPossible(array, middle, key)) { high = middle; }

            else { low = middle + 1; }
        }

        if (!isPossible(array, low, key)) { return -1; }

        return low;
    }

    public static void main(String[] args) {
        int N = inputScanner.nextInt();
        int[] D = new int[N];

        int low = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            D[i] = inputScanner.nextInt();

            if (D[i] > low) { low = D[i]; }

            high += D[i];
        }

        int P = inputScanner.nextInt();
        
        for (int i = 0; i < P; i++) {
            int key = inputScanner.nextInt();
            
            System.out.println(binarySearch(D, low, high, key));
        }
    }
}