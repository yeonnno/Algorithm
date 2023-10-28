/**
 * BOJ : 20007 G4 떡 돌리기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20007_떡돌리기 {

    static int N, M, X, Y, res, INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
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

        dist = new int[N];
        Arrays.fill(dist, INF);
        dist[Y] = 0;
        visited = new boolean[N];

        dijkstra(new Node(Y, 0));

        Arrays.sort(dist);

        res = 1;
        visit();

        System.out.println(res);
    }

    private static void visit() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (dist[i] * 2 > X) {
                res = -1;
                break;
            }

            sum += dist[i] * 2;

            if (sum > X) {
                res++;
                sum = dist[i] * 2;
            }
        }
    }

    private static void dijkstra(Node node) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(node);

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
