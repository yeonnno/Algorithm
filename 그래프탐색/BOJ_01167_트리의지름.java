/**
 * BOJ : 1167 G2 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01167_트리의지름 {

    static int V, start, res;
    static ArrayList<Point>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        V = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = 0;

            while (true) {
                y = Integer.parseInt(st.nextToken());

                if (y == -1) break;

                int cost = Integer.parseInt(st.nextToken());

                adj[x].add(new Point(x, y, cost));
            }
        }

        start = 1;

        res = Integer.MIN_VALUE;
        visited = new boolean[V + 1];
        visited[start] = true;
        dfs(start, 0);

        res = Integer.MIN_VALUE;
        visited = new boolean[V + 1];
        visited[start] = true;
        dfs(start, 0);

        System.out.println(res);
    }

    private static void dfs(int now, int sum) {
        if (res < sum) {
            res = sum;
            start = now;
        }

        for (Point next : adj[now]) {
            if (visited[next.y]) continue;

            visited[next.y] = true;
            dfs(next.y, sum + next.cost);
        }
    }

    private static class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
