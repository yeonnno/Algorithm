/**
 * BOJ : 19941 S3 햄버거 분배
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);

                for (int j = start; j <= end; j++) {
                    if (arr[j] == 'H') {
                        res++;
                        arr[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
