/**
 * BOJ : 2146 G3 다리 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02146_다리만들기 {

    static int N, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;

                checkLand(new Point(i, j), idx);
                idx++;
            }
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;

                setBridge(i, j);
            }
        }

        System.out.println(res);
    }

    private static void setBridge(int x, int y) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.offer(new Point(x, y, 0));

        visited = new boolean[N][N];
        visited[x][y] = true;

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (map[now.x][now.y] != 0 && map[now.x][now.y] != map[x][y]) {
                res = Math.min(res, now.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[x][y] == map[nx][ny]) continue;

                visited[nx][ny] = true;

                if (map[nx][ny] == 0)
                    PQ.offer(new Point(nx, ny, now.cnt + 1));
                else
                    PQ.offer(new Point(nx, ny, now.cnt));
            }
        }
    }

    private static void checkLand(Point p, int idx) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);

        visited[p.x][p.y] = true;
        map[p.x][p.y] = idx;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                map[nx][ny] = idx;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
}
