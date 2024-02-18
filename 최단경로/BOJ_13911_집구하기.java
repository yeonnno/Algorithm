/**
 * BOJ : 13911 G2 집 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13911_집구하기 {

    static int V, E, M, S, X, Y, res;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] mcdonaldDist, starbucksDist;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

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

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        mcdonaldDist = new int[V + 1];
        Arrays.fill(mcdonaldDist, INF);

        PQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken());
            mcdonaldDist[idx] = 0;
            PQ.add(new Node(idx, 0));
        }

        dijkstra(mcdonaldDist);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        starbucksDist = new int[V + 1];
        Arrays.fill(starbucksDist, INF);

        PQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int idx = Integer.parseInt(st.nextToken());
            starbucksDist[idx] = 0;
            PQ.add(new Node(idx, 0));
        }

        dijkstra(starbucksDist);

        res = INF;
        for (int i = 1; i <= V; i++) {
            if (mcdonaldDist[i] == 0 || starbucksDist[i] == 0) continue;
            if (mcdonaldDist[i] <= X && starbucksDist[i] <= Y) res = Math.min(res, mcdonaldDist[i] + starbucksDist[i]);
        }

        if (res == INF) System.out.println(-1);
        else System.out.println(res);
    }

    private static void dijkstra(int[] dist) {
        boolean[] visited = new boolean[V + 1];

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if(visited[now.e]) continue;

            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (dist[next.e] > dist[now.e] + next.cost) {
                    dist[next.e] = dist[now.e] + next.cost;
                    PQ.add(new Node(next.e, dist[next.e]));
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
