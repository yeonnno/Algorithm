/**
 * BOJ : 3665 G1 최종 순위
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_03665_최종순위 {

    static int N, M;
    static int[] rank, indegree, res;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            rank = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            indegree = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    adj[rank[i]].add(rank[j]);
                    indegree[rank[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a].contains(b)) {
                    adj[a].remove(Integer.valueOf(b));
                    adj[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    adj[b].remove(Integer.valueOf(a));
                    adj[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            topologySort();
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                cnt++;
                Q.add(i);
            }
        }

        if (cnt > 1) {
            sb.append("?\n");
            return;
        }

        res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (Q.isEmpty()) {
                sb.append("IMPOSSIBLE\n");
                return;
            }

            int now = Q.poll();

            res[i] = now;

            for (int next : adj[now]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    Q.add(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        sb.append("\n");
    }
}
