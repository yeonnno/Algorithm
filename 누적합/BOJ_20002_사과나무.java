/**
 * BOJ : 20002 G5 사과나무
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20002_사과나무 {

    static int N, res;
    static int[][] map, preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        preSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + map[i][j];
            }
        }

        res = Integer.MIN_VALUE;
        for (int k = 0; k <= N; k++) {
            for (int i = 1; i <= N - k; i++) {
                for (int j = 1; j <= N - k; j++) {
                    int profit = preSum[i + k][j + k] - preSum[i - 1][j + k] - preSum[i + k][j - 1] + preSum[i - 1][j - 1];
                    res = Math.max(res, profit);
                }
            }
        }

        System.out.println(res);
    }
}
