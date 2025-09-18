/**
 * BOJ : 22352 G5 항체 인식
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22352_항체인식 {

    static int N, M;
    static int[][] beforeMap, afterMap;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beforeMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                beforeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        afterMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                afterMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findDiff();

        if (check())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (beforeMap[i][j] != afterMap[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void findDiff() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (beforeMap[i][j] != afterMap[i][j]) {
                    BFS(i, j, afterMap[i][j]);
                    return;
                }
            }
        }
    }

    private static void BFS(int x, int y, int after) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited = new boolean[N][M];
        visited[x][y] = true;

        int before = beforeMap[x][y];
        beforeMap[x][y] = after;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (beforeMap[nx][ny] != before) continue;

                visited[nx][ny] = true;
                beforeMap[nx][ny] = after;
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
