import java.util.LinkedList;
import java.util.Scanner;

public class DAA029 {
    final static Scanner inputScanner = new Scanner(System.in);

    static LinkedList<Integer> orderList = new LinkedList<Integer>();
    static boolean[][] edges = new boolean[26][26];
    static boolean[] visited = new boolean[26];

    public static void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < 26; i++) {
            if (edges[node][i] && !visited[i]) { dfs(i); }
        }

        orderList.addFirst(node);
    }

    public static void main(String[] args) {
        int N = inputScanner.nextInt();

        boolean[] used = new boolean[26];

        String rowA = inputScanner.next();
        for (int i = 1; i < N; i++) {
            String rowB = inputScanner.next();

            for (int j = 0; j < rowA.length() && j < rowB.length(); j++) {
                if (rowA.charAt(j) != rowB.charAt(j)) {
                    int nodeA = rowA.charAt(j) - 'A';
                    int nodeB = rowB.charAt(j) - 'A';
                    edges[nodeA][nodeB] = true;
                    used[nodeA] = true;
                    used[nodeB] = true;
                    break;
                }
            }

            rowA = rowB;
        }

        for (int i = 0; i < 26; i++) {
            if (!visited[i] && used[i]) { dfs(i); }
        }

        int orderListSize = orderList.size();
        for (int i = 0; i < orderListSize; i++) {
            System.out.print((char)('A' + orderList.remove()));
        }
        System.out.println();
    }
}