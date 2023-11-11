/**
 * BOJ : 20438 S2 출석체크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20438_출석체크 {

    static int N, K, Q, M, res;
    static List<Integer> sleep;
    static boolean[] check;
    static int[] preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 3];

        sleep = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleep.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int code = Integer.parseInt(st.nextToken());

            if (sleep.contains(code)) continue;

            if (!check[code]) {
                for (int j = code; j < N + 3; j++) {
                    if (j % code == 0 && !sleep.contains(j)) check[j] = true;
                }
            }
        }

        preSum = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            preSum[i] = preSum[i - 1];
            if (!check[i]) preSum[i] += 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(preSum[E] - preSum[S - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
