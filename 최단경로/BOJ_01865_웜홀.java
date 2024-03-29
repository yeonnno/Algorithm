/**
 * BOJ : 1865 G3 웜홀
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01865_웜홀 {

    static int N, M, W;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if (i < M) {
                    adj[s].add(new Node(e, cost));
                    adj[e].add(new Node(s, cost));
                } else {
                    adj[s].add(new Node(e, -cost));
                }
            }

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;

            if (bellman()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }

    private static boolean bellman() {
        boolean isUpdate = false;

        for (int i = 1; i < N; i++) {
            isUpdate = false;

            for (int j = 1; j <= N; j++) {
                for (Node next : adj[j]) {
                    if (dist[next.e] > dist[j] + next.cost) {
                        dist[next.e] = dist[j] + next.cost;
                        isUpdate = true;
                    }
                }
            }

            if (!isUpdate) break;
        }

        if (isUpdate) {
            for (int i = 1; i <= N; i++) {
                for (Node next : adj[i]) {
                    if (dist[next.e] > dist[i] + next.cost) return true;
                }
            }
        }

        return false;
    }

    private static class Node {
        int e;
        int cost;

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
