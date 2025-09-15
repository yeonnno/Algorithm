/**
 * BOJ : 17836 G5 공주님을 구해라!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_공주님을구해라 {

    static int N, M, T;
    static final int MAX = 10001;
    static int[][] map, dist;
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
        dist = new int[N][M];
        Point sword = new Point(-1, -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    sword.x = i;
                    sword.y = j;
                }

                dist[i][j] = MAX;
            }
        }

        BFS();

        int res1 = dist[N - 1][M - 1];
        int res2 = dist[sword.x][sword.y] + ((N - sword.x - 1) + (M - sword.y - 1));
        int min = Math.min(res1, res2);

        if (min > T)
            System.out.println("Fail");
        else
            System.out.println(min);
    }

    private static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));

        dist[0][0] = 0;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || map[nx][ny] == 1) continue;

                if (dist[nx][ny] > dist[now.x][now.y] + 1) {
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
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
