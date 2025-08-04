/**
 * BOJ : 1051 S3 숫자 정사각형
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01051_숫자정사각형 {

    static int N, M, min, res;
    static int[][] map;

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
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = 1;
        min = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int area = findSquare(i, j);

                res = Math.max(res, area);
            }
        }

        System.out.println(res);
    }

    private static int findSquare(int x, int y) {
        int val = map[x][y], max = 1;

        for (int d = 0; d < min; d++) {
            int nx = x + d;
            int ny = y + d;

            if (!isPossible(nx, ny))
                break;

            if (val == map[x][ny] && val == map[nx][y] && val == map[nx][ny])
                max = Math.max(max, (d + 1) * (d + 1));
        }

        return max;
    }

    private static boolean isPossible(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
