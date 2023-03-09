/**
 * BOJ : 2178 S1 미로 탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02178_미로탐색 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = 0;
        visited = new boolean[N][M];
        BFS(new Point(0, 0, 1));

        System.out.println(res);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(p);
        visited[p.x][p.y] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx == N - 1 && ny == M - 1) {
                    res = cnt+1;
                    return;
                }

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                Q.add(new Point(nx, ny, cnt + 1));
                visited[nx][ny] = true;
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    static class Point {
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
