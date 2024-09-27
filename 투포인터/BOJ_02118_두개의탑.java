/**
 * BOJ : 2118 G5 두 개의 탑
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02118_두개의탑 {

    static int N, sum, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sum = 0;
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        res = 0;
        int start = 0, end = 0;
        int now = arr[start];
        while (start <= end && end < N) {
            int min = Math.min(now, sum - now);

            res = Math.max(res, min);

            if (now == min) {
                end++;
                now += arr[end];
            } else {
                now -= arr[start];
                start++;
            }
        }

        System.out.println(res);
    }
}
