import java.util.Arrays;
import java.util.Scanner;


public class DAA010 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static int[] getSumsArray(int[] S, int N) {
        int[] sumsArray = new int[N * (N - 1) / 2];
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                sumsArray[index] = S[i] + S[j];
                index++;
            }
        }

        return sumsArray;
    }

    public static int binarySearch(int[] array, int low, int high, int key) {
        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] == key) { return middle; }

            else if (array[middle] > key) { high = middle - 1; }

            else { low = middle + 1; }
        }

        if (high < 0) { high = 0; }

        if (low > array.length - 1) { low = array.length - 1; }

        if (Math.abs(array[high] - key) < Math.abs(array[low] - key)) { return high; }

        return low;
    }

    public static void checkLeft(int[] array, int index, int key) {
        if (index > 0 && array[index] != array[index - 1] && Math.abs(array[index - 1] - key) == Math.abs(array[index] - key)) {
            checkLeft(array, index - 1, key);
            System.out.print(array[index - 1] + " "); 
        }
    }

    public static void checkRight(int[] array, int index, int key) {
        if (index < array.length - 1 && array[index] != array[index + 1] && Math.abs(array[index + 1] - key) == Math.abs(array[index] - key)) {
            checkRight(array, index + 1, key);
            System.out.print(" " + array[index + 1]);
        }
    }

    public static void main(String[] args) {
        int N = inputScanner.nextInt();
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = inputScanner.nextInt();
        }

        int[] sumsArray = getSumsArray(S, N);
        Arrays.sort(sumsArray);

        int Q = inputScanner.nextInt();

        for (int i = 0; i < Q; i++) {
            int key = inputScanner.nextInt();
            int closestIndex = binarySearch(sumsArray, 0, N * (N - 1) / 2 - 1, key);

            checkLeft(sumsArray, closestIndex, key);
            System.out.print(sumsArray[closestIndex]);
            checkRight(sumsArray, closestIndex, key);
            System.out.println();
        }
    }
}
