/**
 * BOJ : 2665 G4 미로만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_02665_미로만들기 {

    static int N, res;
    static boolean[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '1')
                    map[i][j] = true;
            }
        }

        res = 0;
        visited = new boolean[N][N];

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        Deque<Point> DQ = new LinkedList<>();
        DQ.offer(new Point(0, 0, 0));

        visited[0][0] = true;

        while (!DQ.isEmpty()) {
            Point now = DQ.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                res = now.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if (map[nx][ny])
                    DQ.offerFirst(new Point(nx, ny, now.cnt));
                else
                    DQ.offerLast(new Point(nx, ny, now.cnt + 1));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
