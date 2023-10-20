/**
 * BOJ : 11657 G4 타임머신
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {

    static int N, M, INF = 999999999;
    static Node[] adj;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[i] = new Node(s, e, w);
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        if (bellman()) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) sb.append(-1);
                else sb.append(dist[i]);
                sb.append("\n");
            }
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bellman() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node node = adj[j];

                if (dist[node.s] != INF && dist[node.e] > dist[node.s] + node.w) {
                    dist[node.e] = dist[node.s] + node.w;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            Node node = adj[i];

            if (dist[node.s] != INF && dist[node.e] > dist[node.s] + node.w) return false;
        }

        return true;
    }

    private static class Node {
        int s;
        int e;
        int w;

        Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
