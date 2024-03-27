/**
 * BOJ : 1944 G1 복제 로봇
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01944_복제로봇 {

    static int N, M, res;
    static char[][] map;
    static ArrayList<Point> list;
    static PriorityQueue<Point> PQ;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S' || map[i][j] == 'K')
                    list.add(new Point(i, j, 0));
            }
        }

        PQ = new PriorityQueue<>();
        for (int i = 0; i < M + 1; i++) {
            BFS(i);
        }

        res = 0;

        kruskal();

        System.out.println(res);
    }

    private static void kruskal() {
        parent = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (find(now.x) == find(now.y)) continue;

            res += now.cost;
            union(now.x, now.y);
            cnt++;
        }

        if (cnt != M) res = -1;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static void BFS(int idx) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(list.get(idx));

        visited = new boolean[N][N];
        visited[list.get(idx).x][list.get(idx).y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            if (map[now.x][now.y] == 'S' || map[now.x][now.y] == 'K') {
                for (int i = idx + 1; i < M + 1; i++) {
                    if (list.get(i).x == now.x && list.get(i).y == now.y) {
                        PQ.offer(new Point(idx, i, now.cost));
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == '1') continue;

                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny, now.cost + 1));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
