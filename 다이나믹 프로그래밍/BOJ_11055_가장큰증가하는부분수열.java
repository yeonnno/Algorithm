/**
 * BOJ : 11055 S2 가장 큰 증가하는 부분 수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가하는부분수열 {

    static int N, res;
    static int[] num, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = num[0];
        res = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = num[i];

            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[j] + num[i], dp[i]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
