/**
 * BOJ : 2011 G5 암호코드
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02011_암호코드 {

    static String N;
    static int[] dp;
    static int len, MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        len = N.length();

        dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            int now = N.charAt(i - 1) - '0';

            if (now >= 1 && now <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if (i == 1) continue;

            int pre = N.charAt(i - 2) - '0';

            if (pre == 0) continue;

            int val = pre * 10 + now;

            if (val <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[len] % MOD);
    }
}
