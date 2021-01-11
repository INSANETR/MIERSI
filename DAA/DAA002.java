import java.util.Scanner;

public class DAA002 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static int getNumberDigitSum(int number) {
        int numberDigitSum = 0;

        do {
            numberDigitSum += number % 10;
            number /= 10;
        } while (number > 0);

        return numberDigitSum;
    }

    public static int getNextNumber(int number, int digitSum) {
        int numberDigitSum;

        do {
            number++;
            numberDigitSum = getNumberDigitSum(number);
        } while (numberDigitSum != digitSum);

        return number;
    }

    public static void main(String[] args) {
        int testsNumber = inputScanner.nextInt();

        for (int i = 0; i < testsNumber; i++) {
            int number   = inputScanner.nextInt();
            int digitSum = inputScanner.nextInt();

            System.out.println(getNextNumber(number, digitSum));
        } 
    }
}