/**
 * BOJ : 9024 G5 두 수의 합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_09024_두수의합 {

    static int N, K, res, min;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            num = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                num[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(num);

            res = 0;
            min = Integer.MAX_VALUE;
            int start = 0, end = N - 1;
            while (start < end) {
                int sum = num[start] + num[end];
                int gap = Math.abs(sum - K);

                if (gap == min) {
                    res++;
                } else if (gap < min) {
                    min = gap;
                    res = 1;
                }

                if (sum >= K) end--;
                else start++;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
