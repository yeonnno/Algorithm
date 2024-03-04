/**
 * BOJ : 9470 G3 Strahler 순서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_09470_Strahler순서 {

    static int K, M, P, res;
    static ArrayList<Integer>[] adj;
    static int[] indegree, order, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            adj = new ArrayList[M + 1];
            for (int i = 0; i <= M; i++) {
                adj[i] = new ArrayList<>();
            }

            indegree = new int[M + 1];
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                indegree[b]++;
            }

            order = new int[M + 1]; // 순서
            count = new int[M + 1]; // 같은 순서에서 방문한 횟수
            res = 0;

            topologySort();

            sb.append(K).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= M; i++) {
            if (indegree[i] == 0) {
                Q.add(i);
                order[i]++;
                count[i]++;
            }
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            if (count[now] > 1) order[now]++;

            res = Math.max(res, order[now]);

            for (int next : adj[now]) {
                indegree[next]--;
                if (indegree[next] == 0)
                    Q.add(next);

                if (order[now] == order[next]) {
                    count[next]++;
                }
                else if (order[now] > order[next]) {
                    order[next] = order[now];
                    count[next] = 1;
                }
            }
        }
    }
}
