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

public class BOJ_01504_특정한최단경로 {

    static int N, E, v1, v2, res1, res2, INF = 200000000;
    static ArrayList<Point>[] adj;
    static int[] dist;
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
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Point(e, w));
            adj[e].add(new Point(s, w));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        res1 = res2 = 0;

        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        if (res1 >= INF && res2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(res1, res2));
    }

    private static int dijkstra(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        visited = new boolean[N + 1];

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(start, 0));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Point next : adj[now.e]) {
                if (visited[next.e]) continue;

                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    PQ.add(new Point(next.e, dist[next.e]));
                }
            }
        }

        return dist[end];
    }

    private static class Point implements Comparable<Point> {
        int e;
        int w;

        Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }
}
