/**
 * BOJ : 1654 S2 랜선 자르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01654_랜선자르기 {

    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        long left = 1, right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        right++;

        long res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int a : arr) {
                sum += a / mid;
            }

            if (sum >= N) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }
}
