/**
 * BOJ : 2559 S3 수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02559_수열 {

    static int N, K, res;
    static int[] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            temperature[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += temperature[i];

        res = sum;
        int start = 0, end = K;
        while (end != N) {
            sum -= temperature[start];
            sum += temperature[end];

            res = Math.max(res, sum);

            start++;
            end++;
        }

        System.out.println(res);
    }
}
