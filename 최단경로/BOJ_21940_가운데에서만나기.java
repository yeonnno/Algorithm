/**
 * BOJ : 21940 G4 가운데에서 만나기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21940_가운데에서만나기 {

    static int N, M, K;
    static final int INF = 999999999;
    static int[][] adj;
    static int[] friends;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

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
            int cost = Integer.parseInt(st.nextToken());

            adj[s][e] = cost;
        }

        floyd();

        K = Integer.parseInt(br.readLine());

        friends = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        int min = INF;
        res = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int max = -INF;

            for (int friend : friends) {
                max = Math.max(max, adj[i][friend] + adj[friend][i]);
            }

            if (min > max) {
                res.clear();
                res.add(i);
                min = max;
            } else if (min == max) {
                res.add(i);
            }
        }

        for (int r : res) {
            sb.append(r).append(" ");
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
