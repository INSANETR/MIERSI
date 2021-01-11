// Nota: 
// Há como implememtar sem usar a variável character na class Letter

import java.util.Arrays;
import java.util.Scanner;

class Letter implements Comparable<Letter> {
    char character;
    int frequence;
    int firstOccurrence;

    Letter (char character) {
        this.character = character;
        this.frequence = 0;
        this.firstOccurrence = -1;
    }

    @Override
    public int compareTo(Letter l) {
        if (this.frequence > l.frequence)             { return -1; }
        if (this.frequence < l.frequence)             { return +1; }
        if (this.firstOccurrence < l.firstOccurrence) { return -1; }
        if (this.firstOccurrence > l.firstOccurrence) { return +1; }
        return 0;
    }
}

public class DAA009 {
    final static Scanner inputScanner = new Scanner(System.in);

    public static void setLetterArray(Letter[] letterArray) {
        for (int i = 0; i < 26; i++) {
            char character = (char) ('A' + i);
            Letter letter = new Letter(character);

            letterArray[i] = letter;
        }
    }

    public static void fillLetterArray(Letter[] letterArray, String DNA) {
        for (int i = 0; i < DNA.length(); i++) {
            char character = DNA.charAt(i);
            int index = (int) (character - 'A');

            if (letterArray[index].firstOccurrence == -1) { letterArray[index].firstOccurrence = i; }

            letterArray[index].frequence++; 
        }
    }

    public static void printLetterArray(Letter[] letterArray) {
        for (int i = 0; i < 26; i++) {
            if (letterArray[i].frequence > 0) { System.out.println(letterArray[i].character + " " + letterArray[i].frequence); }
        }
    }

    public static void main(String[] args) {
        Letter[] letterArray = new Letter[26];
        setLetterArray(letterArray);

        String DNA = inputScanner.next();
        fillLetterArray(letterArray, DNA);

        Arrays.sort(letterArray);
        printLetterArray(letterArray);
    }
} 