/**
 * BOJ : 2293 G5 동전 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02293_동전1 {

    static int N, K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[K]);
    }
}
