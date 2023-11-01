/**
 * BOJ : 1238 G3 파티
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01238_파티 {

    static int N, M, X, res, INF = 999999999;
    static ArrayList<Node>[] nAdj, rAdj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nAdj = new ArrayList[N + 1];
        rAdj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nAdj[i] = new ArrayList<>();
            rAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nAdj[s].add(new Node(e, w));
            rAdj[e].add(new Node(s, w));
        }

        int[] go = dijkstra(rAdj);
        int[] back = dijkstra(nAdj);

        res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, go[i] + back[i]);
        }

        System.out.println(res);
    }

    private static int[] dijkstra(ArrayList<Node>[] adj) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(X, 0));

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        visited = new boolean[N + 1];

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    PQ.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist;
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
