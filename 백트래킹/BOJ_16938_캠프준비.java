/**
 * BOJ : 16938 G5 캠프 준비
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938_캠프준비 {

    static int N, L, R, X, res;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;

        backtrack(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(res);
    }

    private static void backtrack(int depth, int cnt, int sum, int min, int max) {
        if (depth == N) {
            if (cnt < 2) return;
            if (sum < L || sum > R) return;
            if (max - min < X) return;

            res++;

            return;
        }

        backtrack(depth + 1, cnt + 1, sum + A[depth], Math.min(min, A[depth]), Math.max(max, A[depth]));
        backtrack(depth + 1, cnt, sum, min, max);
    }
}
