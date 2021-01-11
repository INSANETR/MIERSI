
public class daa005 {
  public static void main(String[] args) {
    FastScanner input = new FastScanner(System.in);

    int N = input.nextInt();
    int[] energia = new int[N + 1];
    int[] somaAcumulada = new int[N + 1];

    energia[0] = 0;
    somaAcumulada[0] = 0;

    for (int i = 1; i < N + 1; i++) {
      energia[i] = input.nextInt();
      somaAcumulada[i] = somaAcumulada[i - 1] + energia[i];
    }

    int F = input.nextInt();

    for (int i = 0; i < F; i++) {
      int A = input.nextInt();
      int B = input.nextInt();

      FastPrint.out.println(somaAcumulada[B] - somaAcumulada[A - 1]);
    }

    FastPrint.out.close();

    return;
  }
}

