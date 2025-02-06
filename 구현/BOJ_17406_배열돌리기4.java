/**
 * BOJ : 17406 G4 배열 돌리기 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {

    static int N, M, K, res;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map, rcs, copyMap;
    static int[] selected;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rcs = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rcs[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

        selected = new int[K];
        visited = new boolean[K];
        copyMap = new int[N][M];
        res = INF;

        permutation(0);

        System.out.println(res);
    }

    private static void permutation(int depth) {
        if (depth == K) {
            rotate();
            res = Math.min(res, getRowSum());
            return;
        }

        for (int cur = 0; cur < K; cur++) {
            if (visited[cur]) continue;

            visited[cur] = true;
            selected[depth] = cur;
            permutation(depth + 1);
            visited[cur] = false;
        }
    }

    private static int getRowSum() {
        int min = INF;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copyMap[i][j];
            }

            min = Math.min(min, sum);
        }

        return min;
    }

    private static void rotate() {
        copy();

        for (int k = 0; k < K; k++) {
            int r = rcs[selected[k]][0];
            int c = rcs[selected[k]][1];
            int S = rcs[selected[k]][2];

            for (int s = 1; s <= S; s++) {
                int x = r - s, y = c - s, dir = 0;
                int tmp = copyMap[x][y];

                while (dir < 4) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= r - s && nx <= r + s && ny >= c - s && ny <= c + s) {
                        copyMap[x][y] = copyMap[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        dir++;
                    }
                }

                copyMap[r - s][c - s + 1] = tmp;
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
