/**
 * BOJ : 7795 S3 먹을 것인가 먹힐 것인가
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_07795_먹을것인가먹힐것인가 {

    static int N, M, res;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            res = 0;

            for (int a : A) {
                int left = 0;
                int right = M - 1;
                int idx = 0;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (B[mid] < a) {
                        left = mid + 1;
                        idx = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                res += idx;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
