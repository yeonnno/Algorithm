/**
 * BOJ : 10159 G4 저울
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {

    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s][e] = 1;
            adj[e][s] = -1;
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                if (adj[i][j] == 0) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;

                    if (adj[i][k] == -1 && adj[k][j] == -1) adj[i][j] = -1;
                }
            }
        }
    }
}
