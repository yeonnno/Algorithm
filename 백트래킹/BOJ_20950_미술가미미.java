/**
 * BOJ : 20950 S2 미술가 미미
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20950_미술가미미 {

    static int N, min, res;
    static int[][] map;
    static int[] gom, mun, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gom = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gom[i] = Integer.parseInt(st.nextToken());
        }

        res = Integer.MAX_VALUE;
        for (int i = 2; i <= N; i++) {
            if (i > 7) break;

            selected = new int[i];
            backtrack(0, 0, i);
        }

        System.out.println(res);
    }

    private static void backtrack(int depth, int pre, int limit) {
        if (depth == limit) {
            mun = new int[3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < limit; j++) {
                    mun[i] += map[selected[j]][i];
                }

                mun[i] /= limit;
            }

            min = 0;
            for (int i = 0; i < 3; i++) {
                min += Math.abs(gom[i] - mun[i]);
            }

            res = Math.min(res, min);
            return;
        }

        for (int cur = pre; cur < N; cur++) {
            selected[depth] = cur;
            backtrack(depth + 1, cur + 1, limit);
        }
    }
}
