/**
 * BOJ : 1261 G4 알고스팟
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 0-1 BFS 풀이
 */
public class BOJ_01261_알고스팟 {

    static int N, M, res;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = 0;
        visited = new boolean[N][M];

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        Deque<Point> DQ = new LinkedList<>();
        DQ.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!DQ.isEmpty()) {
            Point now = DQ.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                res = now.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if (map[nx][ny] == 0) DQ.addFirst(new Point(nx, ny, now.cnt));
                else DQ.add(new Point(nx, ny, now.cnt + 1));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point{
        int x;
        int y;
        int cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
