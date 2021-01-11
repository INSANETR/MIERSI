import java.util.Scanner;

public class DAA018 {
    public static void showCoins(int[] T, int N, int Q) {
        int[] coins = new int[Q + 1];
        int[] use = new int[Q + 1];

        coins[0] = 0;
        use[0] = -1;

        for (int i = 1; i <= Q; i++) {
            coins[i] = Q + 1;

            for (int j = 0; j < N; j++) {
                if (T[j] <= i && 1 + coins[i - T[j]] < coins[i]) {
                    coins[i] = 1 + coins[i - T[j]]; 
                    use[i] = T[j];
                }
            }
        }

       System.out.print(Q + ": ");
       System.out.print("[" + coins[Q] + "] ");

       while (Q != 0) {
           if (Q - use[Q] == 0) { System.out.println(use[Q]); }
           
           else { System.out.print(use[Q] + " "); }
           
           Q -= use[Q];
       } 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = input.nextInt();
        }

        int P = input.nextInt();
        int[] Q = new int[P];

        for (int i = 0; i < P; i++) {
            Q[i] = input.nextInt();
        }

        for (int i = 0; i < P; i++) {
            showCoins(T, N, Q[i]);
        }
    }
}