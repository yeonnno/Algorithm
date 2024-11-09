/**
 * BOJ : 13422 G4 도둑
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13422_도둑 {

    static int N, M, K, total, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            total = 0;
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total += arr[i];
            }

            if (N == M) {
                if (total < K) sb.append("1\n");
                else sb.append("0\n");
            } else {
                res = 0;
                int start = 0, end = M - 1, sum = 0;
                for (int i = 0; i < M; i++)
                    sum += arr[i];

                while (start < N) {
                    if (sum < K) res++;

                    sum -= arr[start++];
                    sum += arr[(++end) % N];
                }

                sb.append(res).append("\n");
            }
        }

        System.out.print(sb);
    }
}
