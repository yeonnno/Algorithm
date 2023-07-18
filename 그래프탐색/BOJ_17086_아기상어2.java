/**
 * BOJ : 17086 S2 아기 상어 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

    static int N, M, res;
    static int[][] map, dist;
    static Queue<Point> Q;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 1) {
                    Q.add(new Point(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        res = 0;
        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny)) continue;

                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    res = Math.max(res, dist[nx][ny]);
                    Q.add(new Point(nx, ny));
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

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
