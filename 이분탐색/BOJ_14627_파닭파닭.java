/**
 * BOJ : 14627 S2 파닭파닭
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14627_파닭파닭 {

    static int S, C;
    static int[] arr;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long left = 1, right = 0;

        arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int a : arr) {
                cnt += a / mid;
            }

            if (cnt >= C) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }

        long sum = 0;
        for (int a : arr) {
            sum += a;
        }

        System.out.println(sum - (res * C));
    }
}
