/**
 * BOJ : 11637 S5 인기 투표
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11637_인기투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0, max = 0, maxIdx = 0;
            boolean check = true;

            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(br.readLine());

                if (max < num) {
                    max = num;
                    maxIdx = i;
                    check = true;
                } else if (max == num) {
                    check = false;
                }

                sum += num;
            }

            if (!check) {
                sb.append("no winner");
            } else if (max >= sum / 2 + 1) {
                sb.append("majority winner ").append(maxIdx);
            } else {
                sb.append("minority winner ").append(maxIdx);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
