/**
 * BOJ : 21610 G5 마법사 상어와 비바라기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        cloud = new LinkedList<>();
        cloud.offer(new Point(N, 1));
        cloud.offer(new Point(N, 2));
        cloud.offer(new Point(N - 1, 1));
        cloud.offer(new Point(N - 1, 2));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1][N + 1];

            moveCloud(d, s);
            waterCopy();
            makeCloud();
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                res += map[i][j];
        }

        System.out.println(res);
    }

    private static void makeCloud() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (map[x][y] >= 2 && !visited[x][y]) {
                    cloud.offer(new Point(x, y));
                    map[x][y] -= 2;
                }
            }
        }
    }

    private static void waterCopy() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (!visited[x][y]) continue;

                int cnt = 0;
                for (int d = 1; d <= 4; d++) {
                    int nx = x + dx[d * 2];
                    int ny = y + dy[d * 2];

                    if (!isPossible(nx, ny)) continue;
                    if (map[nx][ny] == 0) continue;

                    cnt++;
                }

                map[x][y] += cnt;
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx > 0 && nx <= N && ny > 0 && ny <= N) return true;
        else return false;
    }

    private static void moveCloud(int d, int s) {
        while (!cloud.isEmpty()) {
            Point now = cloud.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < s; i++) {
                x += dx[d];
                y += dy[d];

                if (x <= 0) x += N;
                else if (x > N) x -= N;

                if (y <= 0) y += N;
                else if (y > N) y -=N;
            }

            visited[x][y] = true;
            map[x][y]++;
        }
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
