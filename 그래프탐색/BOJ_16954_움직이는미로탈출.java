/**
 * BOJ : 16954 G3 움직이는 미로 탈출
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954_움직이는미로탈출 {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(7, 0));

        while (!Q.isEmpty()) {
            int size = Q.size();
            visited = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();

                if (map[now.x][now.y] == '#') continue;
                if (now.x == 0 && now.y == 7) return 1;

                for (int d = 0; d < 9; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                    if (map[nx][ny] == '#') continue;

                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }

            moveWall();
        }

        return 0;
    }

    private static void moveWall() {
        for (int j = 0; j < 8; j++) {
            for (int i = 7; i >= 0; i--) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) return true;
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
