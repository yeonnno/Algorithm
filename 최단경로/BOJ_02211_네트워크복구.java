/**
 * BOJ : 2211 G2 네트워크 복구
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_02211_네트워크복구 {

    static int N, M, INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist, path;
    static boolean[] visited;
    static HashSet<String> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        path = new int[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        visited = new boolean[N + 1];

        dijkstra();

        res = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            int idx = i;

            while (true) {
                if (path[idx] == 0) break;

                res.add(new String(idx + " " + path[idx]));
                idx = path[idx];
            }
        }

        sb.append(res.size()).append("\n");
        for (String str : res) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(1, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    PQ.add(new Node(next.e, dist[next.e]));
                    path[next.e] = now.e;
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
