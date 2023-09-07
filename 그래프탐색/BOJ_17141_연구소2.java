/**
 * BOJ : 17141 G4 연구소 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

    static int N, M, virusSize, res;
    static int[][] map, copyMap;
    static ArrayList<Point> virus;
    static boolean[] selected;
    static Queue<Point> Q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                    map[i][j] = 0;
                }
            }
        }

        virusSize = virus.size();
        selected = new boolean[virusSize];
        res = Integer.MAX_VALUE;

        backtrack(0, 0);

        if (res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res - 1);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == M) {
            int time = spreadVirus();
            if (checkZero()) res = Math.min(res, time);
            return;
        }

        for (int i = pre; i < virusSize; i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    private static boolean checkZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 0) return false;
            }
        }

        return true;
    }

    private static int spreadVirus() {
        Q = new LinkedList<>();
        copyMap = new int[N][N];

        copy();

        int time = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
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
            time++;
        }

        return time;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < virusSize; i++) {
            if (!selected[i]) continue;

            int x = virus.get(i).x;
            int y = virus.get(i).y;
            copyMap[x][y] = 2;
            Q.add(new Point(x, y));
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
