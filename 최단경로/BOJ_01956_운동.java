/**
 * BOJ : 1956 G4 운동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01956_운동 {

    static int V, E, res, INF = 999999999;
    static int[][] adj;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) adj[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s][e] = w;
        }

        floyd();

        check = false;
        res = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = i + 1; j <= V; j++) {
                if (adj[i][j] != INF && adj[j][i] != INF) {
                    check = true;
                    res = Math.min(res, adj[i][j] + adj[j][i]);
                }
            }
        }

        if (check) System.out.println(res);
        else System.out.println(-1);
    }

    private static void floyd() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }
}
