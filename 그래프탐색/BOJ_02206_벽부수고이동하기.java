/**
 * BOJ : 2206 G3 벽 부수고 이동하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02206_벽부수고이동하기 {

    static int N, M, res;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = -1;
        visited = new boolean[2][N][M];

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0, 0, 1));

        visited[0][0][0] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                res = now.dist;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;

                if (map[nx][ny] == 1 && now.cnt == 0 && !visited[1][nx][ny]) {
                    visited[1][nx][ny] = true;
                    Q.offer(new Point(nx, ny, 1, now.dist + 1));
                } else if (map[nx][ny] == 0 && !visited[now.cnt][nx][ny]) {
                    visited[now.cnt][nx][ny] = true;
                    Q.offer(new Point(nx, ny, now.cnt, now.dist + 1));
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point {
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
    }
}
