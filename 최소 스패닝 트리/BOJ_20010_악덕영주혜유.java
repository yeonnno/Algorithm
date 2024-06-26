/**
 * BOJ : 20010 G2 악덕 영주 혜유
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20010_악덕영주혜유 {

    static int N, K, start, res1, res2;
    static int[] parent;
    static PriorityQueue<Node> PQ;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;

        PQ = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ.offer(new Node(x, y, cost));
        }

        res1 = 0;
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();

        kruskal();

        start = 0;

        res2 = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        dfs(start, 0);

        res2 = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        dfs(start, 0);

        sb.append(res1).append("\n").append(res2);
        System.out.println(sb);
    }

    private static void dfs(int node, int sum) {
        if (res2 < sum) {
            res2 = sum;
            start = node;
        }

        for (Node next : adj[node]) {
            if (visited[next.y]) continue;

            visited[next.y] = true;
            dfs(next.y, sum + next.cost);
        }
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            res1 += node.cost;
            union(node.x, node.y);

            adj[node.x].add(new Node(node.y, node.cost));
            adj[node.y].add(new Node(node.x, node.cost));
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

        public Node(int y, int cost) {
            this.y = y;
            this.cost = cost;
        }

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
