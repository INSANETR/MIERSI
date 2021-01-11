import java.util.Scanner;

public class DAA026 {
    final static Scanner inputScanner = new Scanner(System.in);

    static int L;
    static int C;
    static int count;
    static char[][] petriPlate;
    static boolean[][] visited;

    public static void dfs(int r, int c) {
        if (r < 0 || r >= L + 1 || c < 0 || c >= C + 1) { return; }
        if (visited[r][c] || petriPlate[r][c] != '#')   { return; }
        
        visited[r][c] = true;
        count++;

        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
        dfs(r - 1, c - 1);
        dfs(r - 1, c + 1);
        dfs(r + 1, c - 1);
        dfs(r + 1, c + 1);
    }

    public static void main(String[] args) {
        int N = inputScanner.nextInt();

        for (int i = 0; i < N; i++) {
            L = inputScanner.nextInt();
            C = inputScanner.nextInt();

            petriPlate = new char[L + 1][C + 1];
            visited = new boolean[L + 1][C + 1];

            for (int r = 1; r < L + 1; r++) {
                String line = inputScanner.next();
                
                for (int c = 1; c < C + 1; c++) { 
                    petriPlate[r][c] = line.charAt(c - 1);
                }
            }

            int greatest = 0;

            for (int r = 1; r < L + 1; r++) {
                for (int c = 1; c < C + 1; c++) {
                    count = 0;
                    dfs(r, c);
                    if (count > greatest) { greatest = count; } 
                }
            }

            System.out.println(greatest);
        }
    }
}