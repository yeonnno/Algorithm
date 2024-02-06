/**
 * BOJ : 2458 G4 키 순서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02458_키순서 {

    static int N, M, res;
    static final int INF = 999999999;
    static boolean[][] adj;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s][e] = true;
        }

        floyd();

        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j]) count[i]++;
                if (adj[j][i]) count[i]++;
            }
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) res++;
        }

        System.out.println(res);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][k] && adj[k][j]) adj[i][j] = true;
                }
            }
        }
    }
}
