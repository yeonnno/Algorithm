/**
 * BOJ : 16234 G5 인구 이동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 순회하며 방문하지 않은 나라를 방문
 * 국경선을 열 수 있다면 (인구 이동이 가능하다면) 체크변수를 true
 * 국경선이 열린 (인구이동이 가능한) 나라들을 연합 List에 담아줌
 * 모든 나라 순회를 마치면 연합 인구수 계산
 * 인구 이동을 마치면 다음 반복 수행
 */
public class BOJ_16234_인구이동 {

    static int N, L, R, res;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isMoved;
    static boolean[][] visited;
    static ArrayList<Point> union;

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
                    if (!visited[i][j]) {
                        BFS(new Point(i, j));
                    }
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
        Q.add(p);
        visited[p.x][p.y] = true;
        union.add(p);

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                int tmp = Math.abs(map[x][y] - map[nx][ny]);
                if (tmp >= L && tmp <= R) {
                    visited[nx][ny] = true;
                    isMoved = true;
                    Q.add(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < union.size(); i++) {
            Point u = union.get(i);
            sum += map[u.x][u.y];
        }

        for (int i = 0; i < union.size(); i++) {
            Point u = union.get(i);
            map[u.x][u.y] = sum / union.size();
        }

        union.removeAll(union);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
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
