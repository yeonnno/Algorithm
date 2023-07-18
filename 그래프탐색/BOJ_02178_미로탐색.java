/**
 * BOJ : 2178 S1 미로 탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02178_미로탐색 {

    static int N, M;
    static int[][] map, dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        BFS(new Point(0, 0));

        System.out.println(dist[N-1][M-1]);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(p);
        dist[p.x][p.y] = 1;

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != 1) continue;

                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
