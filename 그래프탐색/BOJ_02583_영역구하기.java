/**
 * BOJ : 2583 S1 영역 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_02583_영역구하기 {

    static int N, M, K, cnt;
    static boolean[][] map, visited;
    static ArrayList<Integer> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            for (int i = ax; i < bx; i++) {
                for (int j = ay; j < by; j++) {
                    map[i][j] = true;
                }
            }
        }

        cnt = 0;
        visited = new boolean[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] || visited[i][j]) continue;

                cnt++;
                BFS(new Point(i, j));
            }
        }

        Collections.sort(list);

        sb.append(cnt).append("\n");
        for (int width : list)
            sb.append(width).append(" ");

        System.out.println(sb);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);

        visited[p.x][p.y] = true;

        int width = 1;
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny]) continue;

                width++;
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }

        list.add(width);
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
