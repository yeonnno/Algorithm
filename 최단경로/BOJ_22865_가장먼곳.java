/**
 * BOJ : 22865 G4 가장 먼 곳
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22865_가장먼곳 {

    static int N, M, res, INF = 999999999;
    static int[] friends, dist, minDist;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        friends = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, w));
            adj[e].add(new Node(s, w));
        }

        dist = new int[N + 1];
        minDist = new int[N + 1];
        Arrays.fill(minDist, INF);

        for (int i = 1; i <= N; i++) {
            if (i != friends[0] && i != friends[1] && i != friends[2]) continue;

            visited = new boolean[N + 1];

            dijkstra(i);
        }

        res = 0;
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (minDist[i] == INF) continue;

            if (max < minDist[i]) {
                max = minDist[i];
                res = i;
            }
        }

        System.out.println(res);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

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

        for (int i = 1; i <= N; i++) {
            if (i == friends[0] || i == friends[1] || i == friends[2]) continue;

            minDist[i] = Math.min(minDist[i], dist[i]);
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
