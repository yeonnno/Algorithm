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

        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][3];
        dp[0][0] = map[0][0]; dp[0][1] = map[0][1]; dp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
