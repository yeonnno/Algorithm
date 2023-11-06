/**
 * BOJ : 1507 G2 궁금한 민호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01507_궁금한민호 {

    static int N, res, INF = 999999999;
    static int[][] oriAdj, preAdj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        oriAdj = new int[N + 1][N + 1]; // 주어진 배열
        preAdj = new int[N + 1][N + 1]; // 플로이드워셜 수행 전 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                oriAdj[i][j] = preAdj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (floyd()) {
            res = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (preAdj[i][j] == INF) continue;

                    res += preAdj[i][j];
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

                    if (oriAdj[i][j] > oriAdj[i][k] + oriAdj[k][j]) {
                        return false;
                    }

                    if (oriAdj[i][j] == oriAdj[i][k] + oriAdj[k][j]) {
                        preAdj[i][j] = INF;
                    }
                }
            }
        }

        return true;
    }
}
