/**
 * BOJ : 2885 S2 초콜릿 식사
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02885_초콜릿식사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int n = 1, cnt = 0;
        while (n < K)
            n *= 2;

        sb.append(n).append(" ");

        while (K > 0) {
            if (K >= n) {
                K -= n;
            } else {
                n /= 2;
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}
