/**
 * BOJ : 15558 G5 점프 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_점프게임 {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {0, 0};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2][N];
        for (int i = 0; i < 2; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        check = false;
        visited = new boolean[2][N];

        BFS();

        if (check) System.out.println(1);
        else System.out.println(0);
    }

    private static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        visited[0][0] = true;
        int time = 1;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();

                // case 1, 2
                for (int d = 0; d < 2; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (ny >= N) {
                        check = true;
                        return;
                    }

                    if (ny < time) continue;
                    if (!isPossible(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }

                // case 3
                int nx = now.x ^ 1;
                int ny = now.y + K;

                if (ny >= N) {
                    check = true;
                    return;
                }

                if (ny < time) continue;
                if (!isPossible(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }

            time++;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < 2 && ny >= 0 && ny < N) return true;
        else return false;
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
