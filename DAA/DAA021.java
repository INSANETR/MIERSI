import java.util.TreeMap;
import java.util.Map; // remover //

public class DAA021 {
    public static void main(String[] args) {
        FastScanner input = new FastScanner(System.in);

        int A = input.nextInt();
        int R = input.nextInt();

        TreeMap<Integer, Integer> M = new TreeMap<Integer, Integer>();

        for (int i = 0; i < A + R; i++) {
            String s = input.next();

            if (s.equals("BAK")) {
                int G = input.nextInt();

                if (M.containsKey(G)) { M.put(G, M.get(G) + 1); }

                else { M.put(G, 1); }
            }

            else {
                int G;

                if (s.equals("MIN")) { G = M.firstEntry().getKey(); }

                else { G = M.lastEntry().getKey(); }
                
                M.put(G, M.get(G) - 1);

                if (M.get(G) == 0) { M.remove(G); }

                FastPrint.out.println(G);
            }
        }

        FastPrint.out.close();
    }
}