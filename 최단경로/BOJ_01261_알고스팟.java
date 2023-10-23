/**
 * BOJ : 1261 G4 알고스팟
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01261_알고스팟 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        BFS(new Point(0, 0, 0));

        System.out.println(res);
    }

    private static void BFS(Point p) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(p);
        visited[p.x][p.y] = true;

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

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
                if (map[nx][ny] == 0) {
                    PQ.add(new Point(nx, ny, now.cnt));
                } else {
                    PQ.add(new Point(nx, ny, now.cnt + 1));
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
}
