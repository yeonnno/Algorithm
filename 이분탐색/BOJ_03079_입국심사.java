/**
 * BOJ : 3079 G5 입국심사
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_03079_입국심사 {

    static int N;
    static int[] arr;
    static long M, max, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new int[N];
        max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        res = Long.MAX_VALUE;
        long left = 0, right = max * M;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int a : arr) {
                long cnt = mid / a;

                if (sum >= M) break;

                sum += cnt;
            }

            if (sum >= M) {
                right = mid - 1;
                res = Math.min(res, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }
}
