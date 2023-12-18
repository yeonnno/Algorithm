/**
 * BOJ : 13702 S3 이상한 술집
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13702_이상한술집 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        long left = 1, right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2; // 막걸리의 양
            int cnt = 0;

            for (int a : arr) {
                cnt += a / mid;
            }

            if (cnt >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
