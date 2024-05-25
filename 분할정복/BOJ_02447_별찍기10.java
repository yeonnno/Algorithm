/**
 * BOJ : 2447 G5 별 찍기 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02447_별찍기10 {

    static int N;
    static char[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        res = new char[N][N];

        recur(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void recur(int x, int y, int size, boolean blank) {
        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++)
                    res[i][j] = ' ';
            }
            return;
        }

        if (size == 1) {
            res[x][y] = '*';
            return;
        }

        int mid = size / 3;
        int cnt = 0;
        for (int i = x; i < x + size; i += mid) {
            for (int j = y; j < y + size; j += mid) {
                cnt++;

                if (cnt == 5)
                    recur(i, j, mid, true);
                else
                    recur(i, j, mid, false);
            }
        }
    }
}
