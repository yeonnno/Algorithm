/**
 * BOJ : 17144 G4 미세먼지 안녕!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

    static int N, M, T, up, down, res;
    static int[][] map, spreadMap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    up = i - 1;
                    down = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();

            // 공기청정기 위쪽
            int[] seqUp = new int[]{0, 1, 2, 3};
            airClean(up - 1, 0, up + 1, seqUp);
            map[up][1] = 0;

            // 공기청정기 아래쪽
            int[] seqDown = new int[]{2, 1, 0, 3};
            airClean(down + 1, down, N, seqDown);
            map[down][1] = 0;
        }

        res = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res += map[i][j];
            }
        }

        System.out.println(res);
    }

    private static void airClean(int i, int minX, int maxX, int[] dir) {
        int x = i, y = 0, d = 0;
        while (d < 4) {
            int nx = x + dx[dir[d]];
            int ny = y + dy[dir[d]];

            if (nx >= minX && nx < maxX && ny >= 0 && ny < M) {
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            } else {
                d++;
            }
        }
    }

    private static void spread() {
        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0)
                    Q.offer(new Point (i, j));
            }
        }

        spreadMap = new int[N][M];

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || map[nx][ny] == -1) continue;

                cnt++;
                spreadMap[nx][ny] += map[now.x][now.y] / 5;
            }

            map[now.x][now.y] -= (map[now.x][now.y] / 5) * cnt;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] += spreadMap[i][j];
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
