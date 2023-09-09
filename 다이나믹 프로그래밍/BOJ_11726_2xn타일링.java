/**
 * BOJ : 11726 S3 2xn 타일링
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[1] = 1;
        if (N > 1) {
            dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }

        System.out.println(dp[N]);
    }
}
