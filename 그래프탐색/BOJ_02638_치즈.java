/**
 * BOJ : 2638 G3 치즈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02638_치즈 {

    static int N, M, cheeseCnt, res;
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

        cheeseCnt = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    cheeseCnt++;
            }
        }

        res = 0;
        while (cheeseCnt != 0) {
            res++;
            visited = new boolean[N][M];

            BFS(new Point(0, 0));

            meltCheese();
        }

        System.out.println(res);
    }

    private static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                if (map[i][j] >= 3) {
                    map[i][j] = 0;
                    cheeseCnt--;
                } else {
                    map[i][j] = 1;
                }
            }
        }
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);
        visited[p.x][p.y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                } else {
                    map[nx][ny]++;
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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
