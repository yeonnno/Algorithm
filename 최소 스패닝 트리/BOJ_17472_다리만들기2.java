/**
 * BOJ : 17472 G1 다리 만들기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 1. 섬 구분하기
 * 2. 섬과 섬 사이 최단거리 구하기 (다리 연결)
 * 3. 모든 섬을 연결하는 다리 길이 최솟값 구하기
 */
public class BOJ_17472_다리만들기2 {

    static int N, M, idx, res;
    static int[] parent;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Point> PQ;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        // 1. 섬 구분하기
        idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) continue;

                checkLand(i, j, idx);
                idx++;
            }
        }

        // 2. 섬과 섬 사이 최단거리 구하기 (다리 연결)
        PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                makeBridge(i, j, map[i][j]);
            }
        }

        // 3. 모든 섬을 연결하는 다리 길이 최솟값 구하기
        parent = new int[idx];
        for (int i = 1; i < idx; i++)
            parent[i] = i;

        res = 0;

        kruskal();

        if (checkParent()) System.out.println(res);
        else System.out.println(-1);
    }

    private static boolean checkParent() {
        int tmp = find(1);
        for (int i = 2; i < idx; i++) {
            if (tmp != find(i)) return false;
        }
        return true;
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (find(now.x) == find(now.y)) continue;

            res += now.cost;
            union(now.x, now.y);
        }
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

    private static void makeBridge(int i, int j, int idx) {
        Queue<Point> Q = new LinkedList<>();
        visited = new boolean[N][M];

        for (int d = 0; d < 4; d++) {
            Q.offer(new Point(i, j, 0));
            visited[i][j] = true;

            while (!Q.isEmpty()) {
                Point now = Q.poll();

                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == idx) continue;

                if (map[nx][ny] != 0) {
                    if (now.cost >= 2) {
                        PQ.offer(new Point(idx, map[nx][ny], now.cost));
                        break;
                    }
                } else {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny, now.cost + 1));
                }
            }

            Q.clear();
        }
    }

    private static void checkLand(int i, int j, int idx) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(i, j));

        map[i][j] = idx;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != -1) continue;

                map[nx][ny] = idx;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

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
