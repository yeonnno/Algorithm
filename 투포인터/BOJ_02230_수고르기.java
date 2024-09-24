/**
 * BOJ : 2230 G5 수 고르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02230_수고르기 {

    static int N, M, res;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        Arrays.sort(num);

        res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < N) {
            int diff = num[end] - num[start];

            if (diff == M) {
                res = M;
                break;
            }

            if (diff < M) {
                end++;
                continue;
            }

            res = Math.min(res, diff);
            start++;
        }

        System.out.println(res);
    }
}
