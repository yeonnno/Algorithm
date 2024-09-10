/**
 * BOJ : 1940 S4 주몽
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01940_주몽 {

    static int N, M, res;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        res = 0;
        int start = 0, end = N - 1, sum = 0;
        while (start < end) {
            sum = num[start] + num[end];

            if (sum == M) {
                res++;
                start++;
                end--;
            } else if (sum < M) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(res);
    }
}
