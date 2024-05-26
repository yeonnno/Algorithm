/**
 * BOJ : 2448 G4 별 찍기 11
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_02448_별찍기11 {

    static int N;
    static char[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        res = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++)
            Arrays.fill(res[i], ' ');

        recur(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(res[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void recur(int x, int y, int size) {
        if (size == 3) {
            res[x][y] = '*';
            res[x + 1][y - 1] = res[x + 1][y + 1] = '*';
            res[x + 2][y - 2] = res[x + 2][y - 1] = res[x + 2][y] = res[x + 2][y + 1] = res[x + 2][y + 2] = '*';

            return;
        }

        int mid = size / 2;

        recur(x, y, mid);
        recur(x + mid, y - mid, mid);
        recur(x + mid, y + mid, mid);
    }
}
