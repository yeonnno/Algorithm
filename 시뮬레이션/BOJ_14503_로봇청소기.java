/**
 * BOJ : 14503 G5 로봇 청소기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

    static int N, M, res;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 1;

        recur(x, y, dir);

        System.out.println(res);
    }

    private static void recur(int x, int y, int dir) {
        map[x][y] = 2;

        for (int d = 0; d < 4; d++) {
            dir = dir - 1 >= 0 ? dir - 1 : 3;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isPossible(nx, ny) || map[nx][ny] != 0) continue;

            res++;
            recur(nx, ny, dir);
            return;
        }

        int nnx = x + dx[(dir + 2) % 4];
        int nny = y + dy[(dir + 2) % 4];

        if (isPossible(nnx, nny) && map[nnx][nny] != 1)
            recur(nnx, nny, dir);
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Point {
        int x;
        int y;
        int dir;
    }
}
