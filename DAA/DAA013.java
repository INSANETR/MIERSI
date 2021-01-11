import java.util.Arrays;
import java.util.Scanner;

class Section implements Comparable<Section>{
    int s;
    int f;

    Section(int s, int f) {
        this.s = s;
        this.f = f;
    }

    @Override
    public int compareTo(Section S) {
        if (this.s < S.s) { return -1; }
        if (this.s > S.s) { return +1; }
        if (this.f > S.f) { return -1; }
        if (this.f < S.f) { return +1; }
        return 0; 
    }
}

public class DAA013 {
    public static int getSectionNumber(Section[] sArray, int N, int M) {
        int count = 0;
        int end = 0;
        int index = 0;
        
        while (end < M) {
            int newEnd = end;

            while (index < N && sArray[index].s <= end) {
                if (sArray[index].f > newEnd) { newEnd = sArray[index].f; }

                index++;
            }

            end = newEnd;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M = input.nextInt();

        int N = input.nextInt();
        Section[] sArray = new Section[N];

        for (int i = 0; i < N; i++) {
            int s = input.nextInt();
            int f = input.nextInt();

            Section S = new Section(s, f);

            sArray[i] = S;
        }

        Arrays.sort(sArray);
        
        System.out.println(getSectionNumber(sArray, N, M));
    }
}