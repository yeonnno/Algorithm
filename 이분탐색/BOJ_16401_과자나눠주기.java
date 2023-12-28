/**
 * BOJ : 16401 S2 과자 나눠주기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16401_과자나눠주기 {

    static int M, N, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 1, right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;

            for (int a : arr) {
                cnt += a / mid;
            }

            if (cnt >= M) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }
}
