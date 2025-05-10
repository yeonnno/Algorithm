/**
 * BOJ : 1946 S1 신입 사원
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x] = y;
            }

            int res = 1, min = arr[1];
            for (int i = 2; i <= N; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    res++;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
