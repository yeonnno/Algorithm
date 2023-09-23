/**
 * BOJ : 02294 G5 동전 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02294_동전2 {

    static int N, K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        if (dp[K] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
