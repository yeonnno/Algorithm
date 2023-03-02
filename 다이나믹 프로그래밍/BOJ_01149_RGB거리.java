/**
 * BOJ : 1149 S1 RGB거리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01149_RGB거리 {

    static int N;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = map[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = map[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = map[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (res > dp[N - 1][i]) {
                res = dp[N - 1][i];
            }
        }

        System.out.println(res);
    }
}
