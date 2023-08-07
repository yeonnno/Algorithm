/**
 * BOJ : 1189 S1 컴백홈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01189_컴백홈 {

    static int R, C, K, res;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[R][C];
        res = 0;
        visited[R-1][0] = true;
        DFS(R-1, 0, 1);

        System.out.println(res);
    }

    private static void DFS(int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            if (cnt == K) res++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny)) continue;
            if (visited[nx][ny] || map[nx][ny] != '.') continue;

            visited[nx][ny] = true;
            DFS(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < R && ny >= 0 && ny < C) return true;
        else return false;
    }
}
