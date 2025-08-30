/**
 * BOJ : 18404 S1 현명한 나이트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18404_현명한나이트 {

    static int N, M;
    static int[] res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = i;
        }

        res = new int[M + 1];
        visited = new boolean[N + 1][N + 1];

        BFS(startX, startY);

        for (int i = 1; i <= M; i++)
            sb.append(res[i]).append(" ");

        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        int cnt = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();

                for (int d = 0; d < 8; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                    visited[nx][ny] = true;

                    if (map[nx][ny] != 0)
                        res[map[nx][ny]] = cnt;

                    Q.offer(new Point(nx, ny));
                }
            }

            cnt++;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx > 0 && nx <= N && ny > 0 && ny <= N;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
