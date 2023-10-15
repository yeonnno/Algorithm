/**
 * BOJ : 1753 G4 최단경로
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01753_최단경로 {

    static int V, E, K, INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        visited = new boolean[V + 1];

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int v) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(v, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;

            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (visited[next.e]) continue;

                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    PQ.add(new Node(next.e, dist[next.e]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
