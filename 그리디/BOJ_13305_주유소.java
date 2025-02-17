/**
 * BOJ : 13305 S3 주유소
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {

    static int N;
    static int[] dist, cost;
    static long res, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        dist = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        res = 0;
        min = cost[0];
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, cost[i]);
            res += (min * dist[i]);
        }

        System.out.println(res);
    }
}
