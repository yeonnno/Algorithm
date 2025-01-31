/**
 * BOJ : 2564 S1 경비원
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02564_경비원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int X = 0;
        int[] map = new int[K];

        for (int i = 0; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            int tmp = 0;

            switch (dir) {
                case 1:
                    tmp = loc;
                    break;
                case 2:
                    tmp = N + M + N - loc;
                    break;
                case 3:
                    tmp = N + M + N + M - loc;
                    break;
                case 4:
                    tmp = N + loc;
                    break;
            }

            if (i < K)
                map[i] = tmp;
            else
                X = tmp;
        }

        int res = 0;
        for (int i = 0; i < K; i++) {
            int d1 = Math.abs(X - map[i]);
            int d2 = N * 2 + M * 2 - d1;

            res += Math.min(d1, d2);
        }

        System.out.println(res);
    }
}
