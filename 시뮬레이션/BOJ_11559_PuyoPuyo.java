/**
 * BOJ : 11559 G4 Puyo Puyo
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_11559_PuyoPuyo {

    static final char[] colorList = {'R', 'G', 'B', 'P', 'Y'};
    static int res;
    static char[][] map;
    static boolean isBomb;
    static boolean[][] visited;
    static Queue<Point> Q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        res = 0;
        while (true) {
            isBomb = false;

            for (int k = 0; k < 5; k++) {
                visited = new boolean[12][6];

                for (int i = 11; i >= 0; i--) {
                    for (int j = 5; j >= 0; j--) {
                        if (map[i][j] != colorList[k] || visited[i][j]) continue;

                        BFS(i, j, colorList[k]);
                    }
                }
            }

            if (!isBomb) break;

            dropPuyo();
            res++;
        }

        System.out.println(res);
    }

    private static void dropPuyo() {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 12; i++) {
                if (map[i][j] == '.') continue;

                stack.push(map[i][j]);
                map[i][j] = '.';
            }

            for (int i = 11; i >= 0; i--) {
                if (stack.isEmpty()) continue;

                map[i][j] = stack.pop();
            }
        }
    }

    private static void BFS(int x, int y, char color) {
        Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        visited[x][y] = true;

        int cnt = 1;
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                cnt++;
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));

                if (cnt >= 4) {
                    cnt = 0;
                    Q.clear();
                    isBomb = true;

                    removePuyo(nx, ny, color);
                }
            }
        }
    }

    private static void removePuyo(int x, int y, char color) {
        Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        map[x][y] = '.';

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != color) continue;

                map[nx][ny] = '.';
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < 12 && ny >= 0 && ny < 6;
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
