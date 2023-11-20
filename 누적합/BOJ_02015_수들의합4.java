/**
 * BOJ : 2015 G4 수들의 합 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_02015_수들의합4 {

    static int N, K;
    static int[] preSum;
    static long res;
    static Map<Integer, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        res = 0;
        map = new HashMap<>();
        preSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            preSum[i] = Integer.parseInt(st.nextToken()) + preSum[i - 1];

            if (preSum[i] == K) res++;

            if (map.containsKey(preSum[i] - K)) {
                res += map.get(preSum[i] - K);
            }

            if (!map.containsKey(preSum[i])) {
                map.put(preSum[i], 1L);
            } else {
                map.put(preSum[i], map.get(preSum[i]) + 1);
            }
        }

        System.out.println(res);
    }
}
