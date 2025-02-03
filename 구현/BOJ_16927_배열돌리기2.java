/**
 * BOJ : 16927 G5 배열 돌리기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기2 {

    static int N, M, R;
    static int[][] arr;
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

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = N, m = M;
        int mode = Math.min(N, M) / 2;
        for (int i = 0; i < mode; i++) {
            rotate(i, n * 2 + m * 2 - 4);
            n -= 2;
            m -= 2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void rotate(int start, int len) {
        int r = R % len;

        for (int i = 0; i < r; i++) {
            int x = start, y = start, dir = 0;
            int tmp = arr[x][y];

            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= start && nx < N - start && ny >= start && ny < M - start) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    dir++;
                }
            }

            arr[start + 1][start] = tmp;
        }
    }
}
