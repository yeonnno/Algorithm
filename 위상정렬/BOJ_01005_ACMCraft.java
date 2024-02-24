/**
 * BOJ : 1005 G3 ACM Craft
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01005_ACMCraft {

    static int N, K, W;
    static int[] indegree, delay, res;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            delay = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            indegree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                indegree[b]++;
            }

            W = Integer.parseInt(br.readLine());
            res = new int[N + 1];

            topologySort();

            sb.append(res[W]).append("\n");
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            res[i] = delay[i];

            if (indegree[i] == 0) {
                Q.add(i);
            }
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : adj[now]) {
                res[next] = Math.max(res[next], res[now] + delay[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    Q.add(next);
                }
            }
        }
    }
}
