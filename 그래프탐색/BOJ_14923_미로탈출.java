/**
 * BOJ : 14923 G4 미로 탈출
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14923_미로탈출 {

    static int N, M, res;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = -1;
        visited = new boolean[2][N][M];

        BFS(startX, startY, endX, endY);

        System.out.println(res);
    }

    private static void BFS(int startX, int startY, int endX, int endY) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.offer(new Point(startX, startY, 0, 0));

        visited[0][startX][startY] = true;

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.x == endX && now.y == endY) {
                res = now.dist;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;

                if (map[nx][ny] == 0 && !visited[now.cnt][nx][ny]) {
                    visited[now.cnt][nx][ny] = true;
                    PQ.offer(new Point(nx, ny, now.cnt, now.dist + 1));
                } else if (map[nx][ny] == 1 && now.cnt == 0 && !visited[1][nx][ny]) {
                    visited[1][nx][ny] = true;
                    PQ.offer(new Point(nx, ny, 1, now.dist + 1));
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
        int dist;

        public Point(int x, int y, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
}
