/**
 * BOJ : 12101 S1 1,2,3더하기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12101_123더하기2 {

    static int N, K, cnt;
    static boolean check;
    static int[] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        check = false;
        backtrack(0, 0);

        if (check) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static void backtrack(int depth, int sum) {
        if (sum > N) return;

        if (sum == N) {
            cnt++;
            if (cnt == K) {
                check = true;
                for (int i = 0; i < depth - 1; i++) {
                    sb.append(dp[i]).append("+");
                }
                sb.append(dp[depth - 1]);
            }
        }

        for (int i = 1; i <= 3; i++) {
            dp[depth] = i;
            backtrack(depth + 1, sum + i);
        }
    }
}
