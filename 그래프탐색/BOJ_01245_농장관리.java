/**
 * BOJ : 1245 G5 농장 관리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01245_농장관리 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited, isTop;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        isTop = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || isTop[i][j]) continue;

                BFS(i, j);
            }
        }

        System.out.println(res);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited = new boolean[N][M];
        visited[x][y] = true;

        ArrayList<Point> topList = new ArrayList<>();

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 8; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                if (map[nx][ny] > map[now.x][now.y]) {
                    return;
                } else if (map[nx][ny] == map[now.x][now.y]) {
                    topList.add(new Point(nx, ny));
                    Q.offer(new Point(nx, ny));
                }

                visited[nx][ny] = true;
            }
        }

        for (Point p : topList)
            isTop[p.x][p.y] = true;

        res++;
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
