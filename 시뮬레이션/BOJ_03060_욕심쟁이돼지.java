/**
 * BOJ : 3060 S5 욕심쟁이 돼지
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03060_욕심쟁이돼지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            long sum = 0;
            int res = 1;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 6; i++)
                sum += Integer.parseInt(st.nextToken());

            while (sum <= N) {
                sum *= 4;
                res++;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
