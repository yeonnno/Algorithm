/**
 * BOJ : 1654 S2 랜선 자르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01654_랜선자르기 {

    static int K, N;
    static int[] num;
    static long left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        num = new int[K];

        left = right = 0;
        for (int i = 0; i < K; i++) {
            num[i] = Integer.parseInt(br.readLine());

            if (right < num[i]) right = num[i];
        }

        right++;

        while (left < right) {
            long sum = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < K; i++) {
                sum += num[i] / mid;
            }

            if (sum < N) right = mid;
            else left = mid + 1;
        }

        System.out.println(left - 1);
    }
}
