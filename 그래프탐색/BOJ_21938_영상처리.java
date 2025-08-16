/**
 * BOJ : 21938 S2 영상처리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21938_영상처리 {

    static int N, M, T, res;
    static int[][] map;
    static boolean[][] visited;
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[i][j] = (r + g + b) / 3;
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = map[i][j] >= T ? 1 : 0;
            }
        }

        res = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
