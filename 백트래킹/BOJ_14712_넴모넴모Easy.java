package 백트래킹;
/**
 * BOJ : 14712 S1 넴모넴모(Easy)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712_넴모넴모Easy {

    static int N, M, res;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = 0;
        map = new boolean[N + 1][M + 1];

        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int idx) {
        if (idx == N * M) {
            res++;
            return;
        }

        int x = idx / M + 1;
        int y = idx % M + 1;

        if (map[x][y - 1] && map[x - 1][y] && map[x - 1][y - 1]) {
            backtrack(idx + 1);
        } else {
            backtrack(idx + 1);

            map[x][y] = true;
            backtrack(idx + 1);
            map[x][y] = false;
        }
    }
}
