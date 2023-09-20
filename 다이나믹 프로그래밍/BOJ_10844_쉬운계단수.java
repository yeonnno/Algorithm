/**
 * BOJ : 10844 S1 쉬운 계단 수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수 {

    static int N, MOD = 1000000000;
    static long[][] dp;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][0] = dp[i - 1][1] % MOD;
                else if (j == 9) dp[i][9] = dp[i - 1][8] % MOD;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        res = 0L;
        for (int i = 0; i < 10; i++) {
            res += dp[N][i];
        }

        System.out.println(res % MOD);
    }
}
