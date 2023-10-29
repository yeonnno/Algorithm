/**
 * BOJ : 2458 G4 키 순서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02458_키순서 {

    static int N, M, res, INF = 999999999;
    static int[][] adj;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) adj[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s][e] = 1;
        }

        floyd();

        check = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[j][i] == 1) check[i]++;
                if (adj[i][j] == 1) check[i]++;
            }
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (check[i] == N - 1) res++;
        }

        System.out.println(res);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
//                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
//                        adj[i][j] = adj[i][k] + adj[k][j];
//                    }
                }
            }
        }
    }
}
