/**
 * BOJ : 21940 G4 가운데에서 만나기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21940_가운데에서만나기 {

    static int N, M, K, INF = 999999999;
    static int[][] adj;
    static int[] friends;
    static ArrayList<Integer> res;

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
            int w = Integer.parseInt(st.nextToken());

            adj[s][e] = w;
        }

        K = Integer.parseInt(br.readLine());

        friends = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        floyd();

        res = new ArrayList<>();

        int max = INF;
        for (int i = 1; i <= N; i++) {
            int now = 0;

            for (int f : friends) {
                now = Math.max(now, adj[f][i] + adj[i][f]);
            }

            if (max > now) {
                max = now;
                res.clear();
                res.add(i);
            } else if (max == now) {
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
