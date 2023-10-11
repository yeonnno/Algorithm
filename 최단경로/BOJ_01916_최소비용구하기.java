/**
 * BOJ : 1916 G5 최소비용 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01916_최소비용구하기 {

    static int N, M, start, end, INF = 999999999;
    static ArrayList<Point>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Point(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        visited = new boolean[N + 1];

        dijkstra(start);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int v) {
        PriorityQueue<Point> PQ = new PriorityQueue();
        PQ.add(new Point(start, 0));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (visited[now.e]) continue;

            visited[now.e] = true;

            for (int i = 0; i < adj[now.e].size(); i++) {
                Point next = adj[now.e].get(i);

                if (visited[next.e]) continue;

                if (dist[next.e] > dist[now.e] + next.cost) {
                    dist[next.e] = dist[now.e] + next.cost;
                    PQ.add(new Point(next.e, dist[next.e]));
                }
            }
        }
    }

    private static class Point implements Comparable<Point> {
        int e;
        int cost;

        Point(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
