/**
 * BOJ : 1613 G3 역사
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01613_역사 {

    static int N, K, S;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s][e] = true;
        }

        floyd();

        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (adj[s][e]) sb.append(-1);
            else if (adj[e][s]) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        System.out.println(sb);
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
