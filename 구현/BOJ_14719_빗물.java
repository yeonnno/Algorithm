/**
 * BOJ : 14719 G5 빗물
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int res = 0;

        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int now = map[i];
            int left = now;
            int right = now;

            for (int j = i - 1; j >= 0; j--) {
                if (map[j] > now) {
                    left = Math.max(left, map[j]);
                }
            }

            for (int j = i + 1; j < W; j++) {
                if (map[j] > now) {
                    right = Math.max(right, map[j]);
                }
            }

            if (Math.min(left, right) > now) {
                res += Math.min(left, right) - map[i];
            }
        }

        System.out.println(res);
    }
}
