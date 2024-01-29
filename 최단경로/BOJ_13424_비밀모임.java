/**
 * BOJ : 13424 G4 비밀 모임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 시간 복잡도 : 플로이드-워셜 > 다익스트라
 * 공간 복잡도 : 플로이드-워셜 > 다익스트라
 * N 크기 : 2 <= N <= 100
 */
public class BOJ_13424_비밀모임 {

    static int N, M, K, res;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist, sumDist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
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
                int cost = Integer.parseInt(st.nextToken());

                adj[s].add(new Node(e, cost));
                adj[e].add(new Node(s, cost));
            }

            sumDist = new int[N + 1];

            K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int friend = Integer.parseInt(st.nextToken());

                dist = new int[N + 1];
                Arrays.fill(dist, INF);
                dist[friend] = 0;

                visited = new boolean[N + 1];

                dijkstra(friend);
            }

            res = 0;
            int min = INF;
            for (int i = 1; i <= N; i++) {
                if (min > sumDist[i]) {
                    min = sumDist[i];
                    res = i;
                }
            }

            sb.append(res).append("\n");
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

        for (int i = 1; i <= N; i++) {
            sumDist[i] += dist[i];
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
