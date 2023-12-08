/**
 * BOJ : 1789 S5 수들의 합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01789_수들의합 {

    static long S, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Long.parseLong(br.readLine());
        N = 0;

        long left = 1, right = S;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = (mid * (mid + 1)) / 2;

            if (sum <= S) {
                left = mid + 1;
                N = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(N);
    }
}
