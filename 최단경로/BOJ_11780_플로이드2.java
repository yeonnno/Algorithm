/**
 * BOJ : 11780 G2 플로이드 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11780_플로이드2 {

    static int N, M;
    static final int INF = 999999999;
    static int[][] adj, path;
    static Queue<Integer> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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

            adj[s][e] = Math.min(adj[s][e], cost);
        }

        path = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) path[i][j] = j;
            }
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == INF) adj[i][j] = 0;
                sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }

        Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }

                Q.add(i);

                int idx = i;
                while (true) {
                    if (path[idx][j] == j) break;

                    idx = path[idx][j];
                    Q.add(idx);
                }

                Q.add(j);

                sb.append(Q.size()).append(" ");

                while (!Q.isEmpty()) {
                    sb.append(Q.poll()).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }
}
