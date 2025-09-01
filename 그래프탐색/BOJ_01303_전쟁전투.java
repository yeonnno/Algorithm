/**
 * BOJ : 1303 S1 전쟁-전투
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01303_전쟁전투 {

    static int N, M, wCnt, bCnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        wCnt = 0;
        bCnt = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;

                BFS(i, j, map[i][j]);
            }
        }

        System.out.println(wCnt + " " + bCnt);
    }

    private static void BFS(int x, int y, char color) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        int cnt = 1;
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                cnt++;
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }

        if (color == 'W')
            wCnt += cnt * cnt;
        else
            bCnt += cnt * cnt;
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
