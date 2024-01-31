/**
 * BOJ : 1504 G4 특정한 최단 경로
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 이전 풀이의 개선 버전 (시간 단축)
 */
public class BOJ_01504_특정한최단경로 {

    static int N, E, v1, v2, res1, res2;
    static final int INF = 200000000;
    static ArrayList<Node>[] adj;
    static int[] dist1, distV1, distV2;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
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
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        res1 = res2 = 0;
        dist1 = dijkstra(1);
        distV1 = dijkstra(v1);
        distV2 = dijkstra(v2);

        res1 = dist1[v1] + distV1[v2] + distV2[N];
        res2 = dist1[v2] + distV2[v1] + distV1[N];

        if (res1 >= INF && res2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(res1, res2));
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        visited = new boolean[N + 1];

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

        return dist;
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
