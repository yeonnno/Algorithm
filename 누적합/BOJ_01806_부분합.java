/**
 * BOJ : 1806 G4 부분합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01806_부분합 {

    static int N, S;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;
        while (left <= right && right <= N) {
            if (sum < S) {
                sum += num[right++];
            } else {
                res = Math.min(res, right - left);
                sum -= num[left++];
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
