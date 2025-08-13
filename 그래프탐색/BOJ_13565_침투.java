/**
 * BOJ : 13565 S2 침투
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13565_침투 {

    static int N, M;
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
                char x = s.charAt(j);

                if (x == '0')
                    map[i][j] = false;
                else
                    map[i][j] = true;
            }
        }

        visited = new boolean[N][M];

        for (int j = 0; j < M; j++) {
            if (map[0][j] || visited[0][j]) continue;

            BFS(0, j);
        }

        boolean check = false;
        for (int j = 0; j < M; j++) {
            if (visited[N - 1][j]) {
                check = true;
                break;
            }
        }

        if (check)
            System.out.println("YES");
        else
            System.out.println("NO");
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

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny]) continue;

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
