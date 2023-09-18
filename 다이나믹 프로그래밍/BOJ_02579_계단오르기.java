/**
 * BOJ : 2579 S3 계단 오르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02579_계단오르기 {

    static int N;
    static int[] score, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        score = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1];
        dp[1] = score[1];
        if (N > 1) dp[2] = score[1] + score[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[N]);
    }
}
