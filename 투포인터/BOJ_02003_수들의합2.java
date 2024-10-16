/**
 * BOJ : 2003 S4 수들의 합 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02003_수들의합2 {

    static int N, M, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = 0;
        int start = 0, end = 0, sum = 0;
        while (end <= N) {
            if (sum < M)
                sum += arr[end++];
            else
                sum -= arr[start++];

            if (sum == M) res++;
        }

        System.out.println(res);
    }
}
