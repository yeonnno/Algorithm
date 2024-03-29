/**
 * BOJ : 9370 G2 미확인 도착지
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_09370_미확인도착지 {

    static int N, M, T, S, G, H;
    static final int INF = 100000000;
    static ArrayList<Node>[] adj;
    static int[] dist, candidates;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if ((s == G && e == H) || (s == H && e == G)) {
                    adj[s].add(new Node(e, cost * 2 - 1));
                    adj[e].add(new Node(s, cost * 2 - 1));
                } else {
                    adj[s].add(new Node(e, cost * 2));
                    adj[e].add(new Node(s, cost * 2));
                }
            }

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[S] = 0;

            visited = new boolean[N + 1];

            dijkstra();

            candidates = new int[T];
            for (int i = 0; i < T; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(candidates);

            for (int candidate : candidates) {
                if (dist[candidate] % 2 == 1) sb.append(candidate).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(S, 0));

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
