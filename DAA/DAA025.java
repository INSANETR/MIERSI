import java.util.Scanner;

public class DAA025 {
    final static Scanner inputScanner = new Scanner(System.in);

    static int N;
    static boolean edges[][];
    static boolean visited[];

    public static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i < N + 1; i++) {
            if (edges[node][i] && !visited[i]) { dfs(i); }
        }
    }

    public static int countNetworks() {
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {  
                count++;
                dfs(i);
            }
        }

        return count;
    }

    public static void buildNetworks(int L) {
        for (int i = 0; i < L; i++) {
            int nodeA = inputScanner.nextInt();
            int nodeB = inputScanner.nextInt();
            edges[nodeA][nodeB] = edges[nodeB][nodeA] = true;
        }
    } 

    public static void main(String[] args) {
        N = inputScanner.nextInt();
        edges = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        int L = inputScanner.nextInt();
        buildNetworks(L);

        System.out.println(countNetworks());
    }
}