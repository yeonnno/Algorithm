/**
 * BOJ : 2805 S2 나무 자르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02805_나무자르기 {

    static int N, M, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = -1;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int a : arr) {
                if (a - mid > 0) sum += a - mid;
            }

            if (sum >= M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);
    }
}
