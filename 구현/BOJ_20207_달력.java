/**
 * BOJ : 20207 S1 달력
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207_달력 {

    static int N, res;
    static int[] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        day = new int[367];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                day[j]++;
            }
        }

        res = 0;
        int h = 0;
        int w = 0;
        for (int i = 0; i <= 366; i++) {
            if (day[i] != 0) {
                h = Math.max(h, day[i]);
                w++;
            } else {
                res += h * w;
                h = 0;
                w = 0;
            }
        }

        System.out.println(res);
    }
}
