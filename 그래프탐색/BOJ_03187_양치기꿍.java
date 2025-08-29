/**
 * BOJ : 3187 S1 양치기 꿍
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_03187_양치기꿍 {

    static int N, M, wolfCnt, sheepCnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        wolfCnt = 0;
        sheepCnt = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#' || visited[i][j]) continue;

                BFS(i, j);
            }
        }

        sb.append(sheepCnt).append(" ").append(wolfCnt);
        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        int wCnt = 0, sCnt = 0;

        if (map[x][y] == 'v')
            wCnt++;
        else if (map[x][y] == 'k')
            sCnt++;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == '#') continue;

                if (map[nx][ny] == 'v')
                    wCnt++;
                if (map[nx][ny] == 'k')
                    sCnt++;

                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }

        if (wCnt < sCnt)
            sheepCnt += sCnt;
        else
            wolfCnt += wCnt;
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
