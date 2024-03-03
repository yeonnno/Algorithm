/**
 * BOJ : 1516 G3 게임 개발
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01516_게임개발 {

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] indegree, time, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        time = new int[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int a = Integer.parseInt(st.nextToken());

                if (a == -1) break;

                adj[a].add(i);
                indegree[i]++;
            }
        }

        res = new int[N + 1];

        topologySort();

        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            res[i] = time[i];

            if (indegree[i] == 0)
                Q.add(i);
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : adj[now]) {
                res[next] = Math.max(res[next], res[now] + time[next]);

                indegree[next]--;
                if (indegree[next] == 0)
                    Q.add(next);
            }
        }
    }
}
