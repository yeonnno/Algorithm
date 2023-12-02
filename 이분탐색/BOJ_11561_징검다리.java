/**
 * BOJ : 11561 S3 징검다리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11561_징검다리 {

    static long N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Long.parseLong(br.readLine());

            res = 1;
            long left = 1;
            long right = Integer.MAX_VALUE;

            while (left <= right) {
                long mid = (left + right) / 2;
                long val = mid * (mid + 1) / 2;

                if (val > N) {
                    right = mid - 1;
                } else {
                    res = Math.max(res, mid);
                    left = mid + 1;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
