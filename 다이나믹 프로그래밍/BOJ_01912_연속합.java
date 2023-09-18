/**
 * BOJ : 1912 S2 연속합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01912_연속합 {

    static int N, res;
    static int[] num, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        res = Integer.MIN_VALUE;
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            if (dp[i] > res) res = dp[i];
        }

        System.out.println(res);
    }
}
