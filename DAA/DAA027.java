import java.util.Scanner;

public class DAA027 {
    final static Scanner inputScanner = new Scanner(System.in);

    static int nodesAmmount;
    static boolean edges[][];
    static int stateArray[];
    static boolean isBipartiteGraph;

    // stateArray[node] = 0 -> not visited node
    // stateArray[node] = 1 -> red node
    // stateArray[node] = 2 -> black node 

    public static void dfs (int node, int state) {
        if (stateArray[node] == 0) {
            stateArray[node] = state;

            int newState = state == 1 ? 2 : 1;
            for (int i = 1; i < nodesAmmount + 1; i++) {
                if (edges[node][i]) { dfs(i, newState); }
            }
        }

        else if (state != stateArray[node]) { isBipartiteGraph = false; }
    }

    public static void main(String[] args) {
        int casesAmmount = inputScanner.nextInt();

        for (int i = 0; i < casesAmmount; i++) {
            nodesAmmount = inputScanner.nextInt();
            
            int edgesAmmount = inputScanner.nextInt();

            edges = new boolean[nodesAmmount + 1][nodesAmmount + 1];
            stateArray = new int[nodesAmmount + 1];

            for (int j = 0; j < edgesAmmount; j++) {
                int nodeA = inputScanner.nextInt();
                int nodeB = inputScanner.nextInt();
                edges[nodeA][nodeB] = edges[nodeB][nodeA] = true;
            }

            isBipartiteGraph = true;
            dfs(1, 0);
            String result = isBipartiteGraph ? "sim" : "nao";
            System.out.println(result);
        }   
    }
}