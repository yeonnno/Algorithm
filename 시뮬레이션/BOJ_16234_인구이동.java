/**
 * BOJ : 16234 G4 인구 이동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

    static int N, L, R, res;
    static int[][] map;
    static ArrayList<Point> union;
    static boolean isMoved;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        union = new ArrayList<>();

        move();

        System.out.println(res);
    }

    private static void move() {
        while (true) {
            isMoved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;

                    BFS(new Point(i, j));
                }
            }

            if (isMoved)
                res++;
            else
                break;
        }
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);

        union.add(p);
        visited[p.x][p.y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                int diff = Math.abs(map[now.x][now.y] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    isMoved = true;
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                }
            }
        }

        int sum = 0;
        for (Point now : union)
            sum += map[now.x][now.y];

        int cnt = sum / union.size();
        for (Point now : union)
            map[now.x][now.y] = cnt;

        union.removeAll(union);
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
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
