/**
 * BOJ : 11501 S2 주식
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int max = arr[N];
            long res = 0;
            for (int i = N - 1; i >= 1; i--) {
                if (arr[i] < max)
                    res += max - arr[i];
                else
                    max = arr[i];
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
