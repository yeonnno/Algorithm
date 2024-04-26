/**
 * BOJ : 1600 G3 말이 되고픈 원숭이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01600_말이되고픈원숭이 {

    static int K, N, M, res;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = -1;
        visited = new boolean[K + 1][N][M];

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.offer(new Point(0, 0, 0, 0));

        visited[0][0][0] = true;

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                res = now.dist;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] == 1 || visited[now.cnt][nx][ny]) continue;

                visited[now.cnt][nx][ny] = true;
                PQ.offer(new Point(nx, ny, now.cnt, now.dist + 1));
            }

            for (int d = 0; d < 8; d++) {
                int nx = now.x + hx[d];
                int ny = now.y + hy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] == 1 || now.cnt >= K || visited[now.cnt + 1][nx][ny]) continue;

                visited[now.cnt + 1][nx][ny] = true;
                PQ.offer(new Point(nx, ny, now.cnt + 1, now.dist + 1));
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
        int cnt;
        int dist;

        public Point(int x, int y, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
}
