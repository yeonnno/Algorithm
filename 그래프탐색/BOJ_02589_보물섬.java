/**
 * BOJ : 2589 G5 보물섬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02589_보물섬 {

    static int N, M, res;
    static boolean[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'L')
                    map[i][j] = true;
            }
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) continue;

                visited = new boolean[N][M];
                BFS(i, j);
            }
        }

        System.out.println(res - 1);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        int cnt = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                    if (!map[nx][ny]) continue;

                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }

            cnt++;
        }

        res = Math.max(res, cnt);
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
