/**
 * BOJ : 11780 G2 플로이드 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11780_플로이드2 {

    static int N, M, INF = 999999999;
    static int[][] adj;
    static ArrayList<Integer>[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];
        path = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) adj[i][j] = INF;
                path[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s][e] = Math.min(adj[s][e], w);
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == INF) sb.append(0);
                else sb.append(adj[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int size = path[i][j].size();

                if (i == j || adj[i][j] == INF) {
                    sb.append("0\n");
                    continue;
                }

                sb.append(size + 2).append(" ").append(i).append(" ");
                for (int node : path[i][j]) {
                    sb.append(node).append(" ");
                }
                sb.append(j).append("\n");
            }
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
                        pathTracking(i, j, k);
                    }
                }
            }
        }
    }

    private static void pathTracking(int i, int j, int k) {
        path[i][j].clear();

        for (int node : path[i][k]) {
            path[i][j].add(node);
        }
        path[i][j].add(k);
        for (int node : path[k][j]) {
            path[i][j].add(node);
        }
    }
}
