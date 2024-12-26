/**
 * BOJ : 18111 S2 마인크래프트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {

    static int N, M, B;
    static int[] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int idx = 0;
        map = new int[N * M];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[idx] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[idx]);
                max = Math.max(max, map[idx]);
                idx++;
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int t = 0;
            int block = B;

            for (int j = 0; j < N * M; j++) {
                if (map[j] > i) {
                    t += (map[j] - i) * 2;
                    block += map[j] - i;
                } else if (map[j] < i) {
                    t += i - map[j];
                    block -= i - map[j];
                }
            }

            if (block < 0) break;

            if (time >= t) {
                time = t;
                height = i;
            }
        }

        System.out.println(time + " " + height);
    }
}
