/**
 * BOJ : 15486 G5 퇴사 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        T = new int[N + 2];
        P = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 2];
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) max = dp[i];

            int next = i + T[i];
            if (next < N + 2)
                dp[next] = Math.max(dp[next], max + P[i]);
        }

        System.out.println(dp[N + 1]);
    }
}
