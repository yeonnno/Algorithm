/**
 * BOJ : 1987 G4 알파벳
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01987_알파벳 {

    static int N, M, res;
    static int[][] map;
    static boolean[] visited;
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
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }

        res = 0;
        visited = new boolean[26];

        backtrack(0, 0, 0);

        System.out.println(res);
    }

    private static void backtrack(int x, int y, int cnt) {
        if (visited[map[x][y]]) {
            res = Math.max(res, cnt);
            return;
        }

        visited[map[x][y]] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny)) continue;

            backtrack(nx, ny, cnt + 1);
        }

        visited[map[x][y]] = false;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
}
