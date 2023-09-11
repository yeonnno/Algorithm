/**
 * BOJ : 1890 S1 점프
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01890_점프 {

    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int now = map[i][j];
                if (now == 0) break;

                if (i + now < N) dp[i + now][j] += dp[i][j];
                if (j + now < N) dp[i][j + now] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
