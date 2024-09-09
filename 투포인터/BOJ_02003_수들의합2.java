/**
 * BOJ : 2003 S4 수들의 합 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02003_수들의합2 {

    static int N, M, res;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        res = 0;
        int start = 0, end = 0, sum = 0;
        while (true) {
            if (sum >= M) {
                sum -= num[start++];
            } else if (end == N) {
                break;
            } else {
                sum += num[end++];
            }

            if (sum == M) res++;
        }

        System.out.println(res);
    }
}
