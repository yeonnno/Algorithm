/**
 * BOJ : 1389 S1 케빈 베이컨의 6단계 법칙
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01389_케빈베이컨의6단계법칙 {

    static int N, M, INF = 999999999, min, res;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a][b] = adj[b][a] = 1;
        }

        floyd();

        min = INF;
        res = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += adj[i][j];
            }

            if (min > sum) {
                min = sum;
                res = i;
            }
        }

        System.out.println(res);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }
}
