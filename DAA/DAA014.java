import java.util.Arrays;
import java.util.Scanner;

class Order implements Comparable<Order> {
    int     i;
    int     d;
    int     m;
    float   p;

    Order(int i, int d, int m) {
        this.i = i;
        this.d = d;
        this.m = m;
        this.p = (float)(m) / (float)(d);
    }

    @Override
    public int compareTo(Order o) {
        if (this.p > o.p) { return -1; }
        if (this.p < o.p) { return +1; }
        if (this.i < o.i) { return -1; }
        if (this.i > o.i) { return +1; }
        return 0;
    }
}

public class DAA014 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Order[] oArray = new Order[N];

        for (int i = 0; i < N; i++) {
            int D = input.nextInt();
            int M = input.nextInt();

            Order o = new Order(i + 1, D, M);

            oArray[i] = o;
        }

        Arrays.sort(oArray);

        for (int i = 0; i < N; i++) {
            if (i == N - 1) { System.out.println(oArray[i].i); }

            else { System.out.print(oArray[i].i + " "); }
        }
    }
}