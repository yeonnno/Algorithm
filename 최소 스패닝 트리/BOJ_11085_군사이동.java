/**
 * BOJ : 11085 G3 군사 이동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11085_군사이동 {

    static int P, W, C, V, res;
    static int[] parent;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        parent = new int[P];
        for (int i = 0; i < P; i++)
            parent[i] = i;

        PQ = new PriorityQueue<>();
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ.offer(new Node(x, y, cost));
        }

        res = Integer.MAX_VALUE;

        kruskal();

        System.out.println(res);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            res = Math.min(res, node.cost);
            union(node.x, node.y);

            if (find(C) == find(V)) return;
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
            return o.cost - this.cost;
        }
    }
}
