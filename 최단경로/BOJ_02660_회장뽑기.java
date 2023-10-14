/**
 * BOJ : 2660 G5 회장뽑기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02660_회장뽑기 {

    static int N, INF = 999999999;
    static int[][] adj;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = INF;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            adj[a][b] = adj[b][a] = 1;
        }

        floyd();

        int min = INF;
        int cnt = 0;
        res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int score = 0;

            for (int j = 1; j <= N; j++) {
                if (adj[i][j] != INF) score = Math.max(score, adj[i][j]);
            }

            res[i] = score;

            if (min > score) {
                min = score;
                cnt = 1;
            } else if (min == score) {
                cnt++;
            }
        }
        sb.append(min).append(" ").append(cnt).append("\n");

        for (int i = 1; i <= N; i++) {
            if (res[i] == min) sb.append(i).append(" ");
        }

        System.out.println(sb);
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
