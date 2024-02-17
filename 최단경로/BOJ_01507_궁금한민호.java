/**
 * BOJ : 1507 G2 궁금한 민호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01507_궁금한민호 {

    static int N, res;
    static final int INF = 999999999;
    static int[][] beforeAdj, afterAdj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        beforeAdj = new int[N + 1][N + 1];
        afterAdj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                beforeAdj[i][j] = afterAdj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (floyd()) {
            res = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (beforeAdj[i][j] == INF) continue;

                    res += beforeAdj[i][j];
                }
            }

            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (afterAdj[i][j] > afterAdj[i][k] + afterAdj[k][j]) {
                        return false;
                    } else if (afterAdj[i][j] == afterAdj[i][k] + afterAdj[k][j]) {
                        beforeAdj[i][j] = INF;
                    }
                }
            }
        }

        return true;
    }
}
