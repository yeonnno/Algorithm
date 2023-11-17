/**
 * BOJ : 10713 G5 기차 여행
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10713_기차여행 {

    static int N, M;
    static int[] P, visitCount;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        P = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        visitCount = new int[N + 1];
        for (int i = 2; i <= M; i++) {
            int prev = P[i - 1];
            int next = P[i];

            if (prev > next) {
                int tmp = prev;
                prev = next;
                next = tmp;
            }

            visitCount[prev]++;
            visitCount[next]--;
        }

        for (int i = 1; i <= N; i++) {
            visitCount[i] = visitCount[i] + visitCount[i - 1];
        }

        res = 0;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (visitCount[i] != 0) {
                res += Math.min(a * visitCount[i], b * visitCount[i] + c);
            }
        }

        System.out.println(res);
    }
}
