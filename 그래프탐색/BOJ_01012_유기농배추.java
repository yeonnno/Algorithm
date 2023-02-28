/**
 * BOJ : 1012 S2 유기농 배추
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01012_유기농배추 {

    static int T, M, N, K, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            visited = new boolean[M][N];
            res = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        res++;
                        BFS(new Point(i, j));
                    }
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        visited[p.x][p.y] = true;
        Q.add(p);

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                Q.add(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
            return true;
        }
        return false;
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
