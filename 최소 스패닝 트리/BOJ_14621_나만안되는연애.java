/**
 * BOJ : 14621 G3 나만 안되는 연애
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {

    static int N, M, res;
    static int[] parent, mw;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mw = new int[N + 1];
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (st.nextToken().charAt(0) == 'M')
                mw[i] = 1;

            parent[i] = i;
        }

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

        if (checkParent()) System.out.println(res);
        else System.out.println(-1);
    }

    private static boolean checkParent() {
        int tmp = find(1);
        for (int i = 2; i <= N; i++) {
            if (tmp != find(i)) return false;
        }
        return true;
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (mw[node.x] == mw[node.y]) continue;
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
