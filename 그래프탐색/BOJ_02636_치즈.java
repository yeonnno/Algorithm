/**
 * BOJ : 2636 G4 치즈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02636_치즈 {

    static int N, M, cheese, time, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        time = 0;
        res = 0;
        while (cheese != 0) {
            res = cheese;
            time++;
            visited = new boolean[N][M];

            BFS(new Point(0, 0));
        }

        sb.append(time).append("\n").append(res);

        System.out.println(sb);
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

                visited[nx][ny] = true;

                if (map[nx][ny] == 0) {
                    Q.offer(new Point(nx, ny));
                } else {
                    cheese--;
                    map[nx][ny] = 0;
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
