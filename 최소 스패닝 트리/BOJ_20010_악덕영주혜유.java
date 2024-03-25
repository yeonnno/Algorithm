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

    static int N, K, res, max, start;
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
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            adj[i] = new ArrayList<>();
        }

        PQ = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ.offer(new Node(s, e, cost));
        }

        res = 0;

        kruskal();


        start = 0;

        max = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        dfs(start, 0);

        max = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        dfs(start, 0);

        sb.append(res).append("\n").append(max);
        System.out.println(sb);
    }

    private static void dfs(int node, int sum) {
        if (max < sum) {
            max = sum;
            start = node;
        }

        for (Node next : adj[node]) {
            if (visited[next.e]) continue;

            visited[next.e] = true;
            dfs(next.e, sum + next.cost);
        }
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            int x = find(node.s);
            int y = find(node.e);

            if (isSameParent(x, y)) continue;

            res += node.cost;
            union(node.s, node.e);

            adj[node.s].add(new Node(node.e, node.cost));
            adj[node.e].add(new Node(node.s, node.cost));
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

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
