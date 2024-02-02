/**
 * BOJ : 10282 G4 해킹
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282_해킹 {

    static int N, D, C, res, cnt;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adj[e].add(new Node(s, cost));
            }

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[C] = 0;

            visited = new boolean[N + 1];

            dijkstra(C);

            res = cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (dist[i] == INF) continue;

                res = Math.max(res, dist[i]);
                cnt++;
            }

            sb.append(cnt).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;

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
