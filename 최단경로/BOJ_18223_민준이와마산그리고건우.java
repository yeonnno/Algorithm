/**
 * BOJ : 18223 G4 민준이와 마산 그리고 건우
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {

    static int V, E, P;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist, distP;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, cost));
            adj[e].add(new Node(s, cost));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        visited = new boolean[V + 1];

        dijkstra(1, dist);

        distP = new int[V + 1];
        Arrays.fill(distP, INF);
        distP[P] = 0;

        visited = new boolean[V + 1];

        dijkstra(P, distP);

        if (dist[V] == dist[P] + distP[V]) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }

    private static void dijkstra(int start, int[] di) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;

            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (di[next.e] > di[now.e] + next.cost) {
                    di[next.e] = di[now.e] + next.cost;
                    PQ.add(new Node(next.e, di[next.e]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int e;
        int cost;

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
