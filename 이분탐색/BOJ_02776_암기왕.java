/**
 * BOJ : 2776 S4 암기왕
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02776_암기왕 {

    static int N, M;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            num = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int question = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = N;
                boolean flag = false;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (num[mid] < question) left = mid + 1;
                    else if (num[mid] > question) right = mid - 1;
                    else {
                        flag = true;
                        break;
                    }
                }

                if (flag) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
