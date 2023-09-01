/**
 * BOJ : 18430 G4 무기 공학
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430_무기공학 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dx = {
            {0, 1},
            {0, -1},
            {0, -1},
            {0, 1}
    };
    static int[][] dy = {
            {-1, 0},
            {-1, 0},
            {1, 0},
            {1, 0}
    };

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

        res = 0;
        visited = new boolean[N][M];

        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int idx, int sum) {
        if (idx == N * M) {
            res = Math.max(res, sum);
            return;
        }

        int x = idx / M;
        int y = idx % M;
        for (int d = 0; d < 4; d++) {
            int ax = x + dx[d][0];
            int ay = y + dy[d][0];
            int bx = x + dx[d][1];
            int by = y + dy[d][1];

            if (!isPossible(ax, ay) || !isPossible(bx, by)) continue;
            if (visited[x][y] || visited[ax][ay] || visited[bx][by]) continue;

            visited[x][y] = true;
            visited[ax][ay] = true;
            visited[bx][by] = true;

            int tmp = map[x][y] * 2 + map[ax][ay] + map[bx][by];
            backtrack(idx + 1, sum + tmp);

            visited[x][y] = false;
            visited[ax][ay] = false;
            visited[bx][by] = false;
        }

        backtrack(idx + 1, sum);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
}
