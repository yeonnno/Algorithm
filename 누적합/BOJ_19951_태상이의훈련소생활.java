/**
 * BOJ : 19951 G5 태상이의 훈련소 생활
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19951_태상이의훈련소생활 {

    static int N, M;
    static int[] map, preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        preSum = new int[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            preSum[a] += k;
            preSum[b + 1] -= k;
        }

        for (int i = 1; i <= N; i++) {
            preSum[i] += preSum[i - 1];
            map[i] += preSum[i];

            sb.append(map[i]).append(" ");
        }

        System.out.println(sb);
    }
}
