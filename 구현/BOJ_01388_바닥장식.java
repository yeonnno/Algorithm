/**
 * BOJ : 1388 S4 바닥 장식
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01388_바닥장식 {

    static int N, M, res;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }

        res = 0;
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) continue;

                DFS(i, j);
            }
        }

        System.out.println(res);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == '-') {
            if (y == M) {
                res++;
                return;
            }

            int ny = y + 1;

            if (!visited[x][ny] && map[x][ny] == '-') {
                DFS(x, ny);
            } else {
                res++;
                return;
            }
        }

        if (map[x][y] == '|') {
            if (x == N) {
                res++;
                return;
            }

            int nx = x + 1;

            if (!visited[nx][y] && map[nx][y] == '|') {
                DFS(nx, y);
            } else {
                res++;
                return;
            }
        }
    }
}
