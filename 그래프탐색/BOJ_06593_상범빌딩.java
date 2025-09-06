/**
 * BOJ : 6593 G5 상범 빌딩
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_06593_상범빌딩 {

    static int L, R, C;
    static char[][][] map;
    static Point start, end;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    String s = br.readLine();
                    for (int j = 0; j < C; j++) {
                        map[k][i][j] = s.charAt(j);

                        if (map[k][i][j] == 'S')
                            start = new Point(k, i, j, 0);
                        else if (map[k][i][j] == 'E')
                            end = new Point(k, i, j, 0);
                    }
                }
                br.readLine();
            }

            visited = new boolean[L][R][C];

            int res = BFS();

            if (res == -1)
                sb.append("Trapped!\n");
            else
                sb.append("Escaped in ").append(res).append(" minute(s).\n");
        }

        System.out.print(sb);
    }

    private static int BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(start);

        visited[start.z][start.x][start.y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            if (now.z == end.z && now.x == end.x && now.y == end.y)
                return now.cnt;

            for (int d = 0; d < 6; d++) {
                int nz = now.z + dz[d];
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nz, nx, ny) || visited[nz][nx][ny]) continue;
                if (map[nz][nx][ny] == '#') continue;

                visited[nz][nx][ny] = true;
                Q.offer(new Point(nz, nx, ny, now.cnt + 1));
            }
        }

        return -1;
    }

    private static boolean isPossible(int nz, int nx, int ny) {
        return nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C;
    }

    private static class Point {
        int z, x, y, cnt;

        public Point(int z, int x, int y, int cnt) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
