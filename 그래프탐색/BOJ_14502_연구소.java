/**
 * BOJ : 14502 G4 연구소
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

    static int N, M, res;
    static int[][] map, copyMap;
    static Queue<Point> Q;
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MIN_VALUE;

        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int depth) {
        if (depth == 3) {
            spreadVirus();
            countSafe();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) continue;

                map[i][j] = 1;
                backtrack(depth + 1);
                map[i][j] = 0;
            }
        }
    }

    private static void countSafe() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }

        res = Math.max(res, cnt);
    }

    private static void spreadVirus() {
        Q = new LinkedList<>();
        copyMap = new int[N][M];

        copy();

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (copyMap[nx][ny] != 0) continue;

                copyMap[nx][ny] = 2;
                Q.add(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];

                if (copyMap[i][j] == 2) {
                    Q.add(new Point(i, j));
                }
            }
        }
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
