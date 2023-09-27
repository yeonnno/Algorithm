/**
 * BOJ : 16926 S1 배열 돌리기 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {

    static int N, M, R;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            rotate();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotate() {
        int mode = Math.min(N, M) / 2;

        for (int m = 0; m < mode; m++) {
            int x = m;
            int y = m;
            int tmp = map[x][y];
            int d = 0;

            while (d < 4) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= m && nx < N - m && ny >= m && ny < M - m) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    d++;
                }
            }

            map[m + 1][m] = tmp;
        }
    }
}
