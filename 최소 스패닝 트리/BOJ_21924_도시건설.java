/**
 * BOJ : 21924 G4 도시 건설
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21924_도시건설 {

    static int N, M;
    static long total;
    static int[] parent;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        total = 0;
        PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ.offer(new Node(x, y, cost));
            total += cost;
        }

        kruskal();

        if (check()) System.out.println(total);
        else System.out.println(-1);
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            if (find(1) != find(i))
                return false;
        }
        return true;
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            total -= node.cost;
            union(node.x, node.y);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
