/**
 * BOJ : 21736 S2 헌내기는 친구가 필요해
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {

    static int N, M, res;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 0, startY = 0;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }

            }
        }

        res = 0;
        visited = new boolean[N][M];

        BFS(startX, startY);

        if (res == 0)
            System.out.println("TT");
        else
            System.out.println(res);
    }

    private static void BFS(int startX, int startY) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(startX, startY));

        visited[startX][startY] = true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;

                if (map[nx][ny] == 'P')
                    res++;

                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
