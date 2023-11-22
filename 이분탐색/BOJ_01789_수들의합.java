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

        binarySearch(1, S);

        System.out.println(N);
    }

    private static void binarySearch(long start, long end) {
        if (start > end) return;

        long mid = (start + end) / 2;
        long sum = (mid * (mid + 1)) / 2;

        if (sum > S) {
            binarySearch(start, mid - 1);
        } else if (sum < S) {
            N = Math.max(N, mid);
            binarySearch(mid + 1, end);
        } else {
            N = mid;
            return;
        }
    }
}
