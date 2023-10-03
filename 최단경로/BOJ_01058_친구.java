/**
 * BOJ : 1058 S2 친구
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01058_친구 {

    static int N, res, INF = 100000000;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (s.charAt(j - 1) == 'Y') adj[i][j] = 1;
                else if (s.charAt(j - 1) == 'N') adj[i][j] = INF;
            }
        }

        floyd();

        res = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                if (adj[i][j] <= 2) cnt++;
            }

            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || i == k) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }
}
