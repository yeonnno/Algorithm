/**
 * BOJ : 1182 S2 부분수열의 합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01182_부분수열의합 {

    static int N, S, res;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        backtrack(0, 0);

        if (S == 0) res--;

        System.out.println(res);
    }

    private static void backtrack(int depth, int sum) {
        if (depth == N) {
            if (sum == S) res++;
            return;
        }
        
        backtrack(depth + 1, sum + num[depth]);
        backtrack(depth + 1, sum);
    }
}
