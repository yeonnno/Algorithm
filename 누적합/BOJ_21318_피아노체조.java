/**
 * BOJ : 21318 S1 피아노 체조
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318_피아노체조 {

    static int N, Q, X, Y, res;
    static int[] level, preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        level = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        preSum = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (level[i - 1] > level[i]) preSum[i] = preSum[i - 1] + 1;
            else preSum[i] = preSum[i - 1];
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            res = preSum[Y] - preSum[X];
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
