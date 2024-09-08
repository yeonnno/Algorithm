/**
 * BOJ : 2018 S5 수들의 합 5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02018_수들의합5 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int res = 0;
        int start = 1, end = 1, sum = 1;
        while (start <= end) {
            if (sum == N) res++;

            if (sum < N) {
                end++;
                sum += end;
            } else if (sum >= N) {
                sum -= start;
                start++;
            }
        }

        System.out.println(res);
    }
}
