/**
 * BOJ : 1922 G4 네트워크 연결
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * Kruskal 풀이
 */
public class BOJ_01922_네트워크연결_kruskal {

    static int N, M, res;
    static int[] parent;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ.offer(new Node(x, y, cost));
        }

        res = 0;

        kruskal();

        System.out.println(res);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            res += node.cost;
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
