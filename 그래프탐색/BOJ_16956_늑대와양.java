/**
 * BOJ : 16956 S3 늑대와 양
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16956_늑대와양 {

    static int R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static Queue<Point> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'W') {
                    Q.add(new Point(i, j));
                }
            }
        }

        if (BFS()) {
            sb.append(1).append("\n");
            for (int i = 0; i < R; i++) {
                sb.append(map[i]).append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }

    private static boolean BFS() {
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] == 'S') return false;

                if (map[nx][ny] == '.') map[nx][ny] = 'D';
            }
        }

        return true;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < R && ny >= 0 && ny < C) return true;
        return false;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
