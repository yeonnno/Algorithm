/**
 * BOJ : 10025 S3 게으른 백곰
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025_게으른백곰 {

    static int N, K;
    static int[] ice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) * 2 + 1;

        ice = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ice[x] = g;
        }

        int sum = 0, res = 0;
        for (int i = 0; i < 1000001; i++) {
            if (i - K >= 0)
                sum -= ice[i - K];
            sum += ice[i];
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
