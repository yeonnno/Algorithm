/**
 * BOJ : 2056 G4 작업
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02056_작업 {

    static int N, res;
    static int[] indegree, delay, total;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        delay = new int[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            delay[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());

                adj[a].add(i);
                indegree[i]++;
            }
        }

        total = new int[N + 1];

        topologySort();

        res = 0;
        for (int i = 1; i <= N; i++)
            res = Math.max(res, total[i]);

        System.out.println(res);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            total[i] = delay[i];

            if (indegree[i] == 0)
                Q.offer(i);
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : adj[now]) {
                total[next] = Math.max(total[next], total[now] + delay[next]);
                indegree[next]--;

                if (indegree[next] == 0)
                    Q.offer(next);
            }
        }
    }
}
