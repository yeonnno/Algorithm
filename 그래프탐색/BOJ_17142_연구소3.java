/**
 * BOJ : 17142 G3 연구소 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {

    static int N, M, zeroCnt, virusSize, res;
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

        zeroCnt = 0;
        map = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) zeroCnt++;
                else if (map[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        virusSize = virus.size();
        selected = new boolean[virusSize];
        res = Integer.MAX_VALUE;
        if (zeroCnt == 0) res = 0;

        backtrack(0, 0);

        if (res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == M) {
            spreadVirus();
            return;
        }

        for (int i = pre; i < virusSize; i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    private static void spreadVirus() {
        Q = new LinkedList<>();
        copyMap = new int[N][N];

        copy();

        for (int i = 0; i < virusSize; i++) {
            if (!selected[i]) continue;

            Q.add(virus.get(i));
        }

        int time = 0;
        int zCnt = zeroCnt;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny)) continue;

                    if (copyMap[nx][ny] == 0) {
                        zCnt--;
                        copyMap[nx][ny] = 2;
                        Q.add(new Point(nx, ny));
                    } else if (copyMap[nx][ny] == 3) {
                        copyMap[nx][ny] = 2;
                        Q.add(new Point(nx, ny));
                    }


                }
            }

            time++;

            if (zCnt == 0) res = Math.min(res, time);
        }
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
            if (selected[i]) continue;

            Point p = virus.get(i);
            copyMap[p.x][p.y] = 3;
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
