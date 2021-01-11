import java.util.Scanner;

class Plate {
    String sectionA;
    String sectionB;
    String sectionC;    
    int    generation;
    int    number;

    Plate(String sectionA, String sectionB, String sectionC) {
        this.sectionA = sectionA;
        this.sectionB = sectionB;
        this.sectionC = sectionC;
        getGeneration();
        getNumber();
    }

    public void getGeneration() {
        int sampleA = this.sectionA.charAt(0);
        int sampleB = this.sectionB.charAt(0);
        int sampleC = this.sectionC.charAt(0);

        if (Character.isLetter(sampleA) && Character.isDigit(sampleB) && Character.isDigit(sampleC)) { this.generation = 1; }

        else if (Character.isDigit(sampleA) && Character.isDigit(sampleB) && Character.isLetter(sampleC)) { this.generation = 2; }

        else if (Character.isDigit(sampleA) && Character.isLetter(sampleB) && Character.isDigit(sampleC)) { this.generation = 3; }

        else if (Character.isLetter(sampleA) && Character.isDigit(sampleB) && Character.isLetter(sampleC)) { this.generation = 4; }

        else { this.generation = -1; }
    }

    public int letterToNumber(char letter) {
        if (letter >= 'A' && letter <= 'J') { return letter - 'A'; }

        else if (letter >= 'L' && letter <= 'V' ) { return letter - 'A' - 1; }

        else if (letter == 'X') { return letter - 'A' - 2; }

        else if (letter == 'Z') { return letter - 'A' - 3; }

        return -1;
    }

    public void getNumber() {
        this.number = 0;

        if (this.generation == 1) {
            String numberString = this.sectionB + this.sectionC;
            this.number += Integer.parseInt(numberString);
            this.number += letterToNumber(this.sectionA.charAt(1)) * 10000;
            this.number += letterToNumber(this.sectionA.charAt(0)) * 230000;
        }

        else if (this.generation == 2) {
            String numberString = this.sectionA + this.sectionB;
            this.number += Integer.parseInt(numberString);
            this.number += letterToNumber(this.sectionC.charAt(1)) * 10000;
            this.number += letterToNumber(this.sectionC.charAt(0)) * 230000;
            this.number += 5290000;
        }

        else if (this.generation == 3) {
            String numberString = this.sectionA + this.sectionC;
            this.number += Integer.parseInt(numberString);
            this.number += letterToNumber(this.sectionB.charAt(1)) * 10000;
            this.number += letterToNumber(this.sectionB.charAt(0)) * 230000;
            this.number += 10580000;
        }

        else if (this.generation == 4) {
            String numberString = this.sectionB;
            this.number += Integer.parseInt(numberString);
            this.number += letterToNumber(this.sectionC.charAt(1)) * 100;
            this.number += letterToNumber(this.sectionC.charAt(0)) * 2300;
            this.number += letterToNumber(this.sectionA.charAt(1)) * 52900;
            this.number += letterToNumber(this.sectionA.charAt(0)) * 1216700;
            this.number += 15870000;
        }

        else { this.number = -1; }
    }
}

public class DAA003 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testsNumber = inputScanner.nextInt();

        inputScanner.useDelimiter("-|\\s+");

        for (int i = 0; i < testsNumber; i++) {
            String plateSectionA;
            String plateSectionB;
            String plateSectionC;

            plateSectionA = inputScanner.next();
            plateSectionB = inputScanner.next();
            plateSectionC = inputScanner.next();

            Plate plateA = new Plate(plateSectionA, plateSectionB, plateSectionC);

            plateSectionA = inputScanner.next();
            plateSectionB = inputScanner.next();
            plateSectionC = inputScanner.next();

            Plate plateB = new Plate(plateSectionA, plateSectionB, plateSectionC);

            if (plateA.number > plateB.number) { System.out.println(plateA.number - plateB.number); }

            else { System.out.println(plateB.number - plateA.number); }
        }
    }
}