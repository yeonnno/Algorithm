/**
 * BOJ : 18290 S1 NM과 K 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290_NM과K1 {

    static int N, M, K, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
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

        res = Integer.MIN_VALUE;
        visited = new boolean[N][M];

        backtrack(0, 0, 0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int x, int y, int sum) {
        if (depth == K) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (visited[i][j]) continue;

                if (check(i, j)) {
                    visited[i][j] = true;
                    backtrack(depth + 1, i, j, sum + map[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isPossible(nx, ny) && visited[nx][ny]) return false;
        }

        return true;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
}
