/**
 * BOJ : 2406 G3 안정적인 네트워크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_02406_안정적인네트워크 {

    static int N, M, sum, cnt;
    static int[] parent;
    static int[][] adj;
    static PriorityQueue<Node> PQ;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!isSameParent(x, y)) {
                union(x, y);
            }
        }

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PQ = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (i == 1 || j == 1) continue;
                PQ.offer(new Node(i, j, adj[i][j]));
            }
        }

        sum = 0;
        cnt = 0;
        list = new ArrayList<>();

        kruskal();

        if (sum == 0 && cnt == 0) {
            sb.append("0 0");
        } else {
            sb.append(sum).append(" ").append(cnt).append("\n");
            for (int[] li : list) {
                sb.append(li[0]).append(" ").append(li[1]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            int x = node.s;
            int y = node.e;

            if (isSameParent(x, y)) continue;

            sum += node.cost;
            cnt++;
            list.add(new int[]{node.s, node.e});

            union(node.s, node.e);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
