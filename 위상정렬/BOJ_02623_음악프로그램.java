/**
 * BOJ : 2623 G3 음악프로그램
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02623_음악프로그램 {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len - 1; j++) {
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                indegree[y]++;
                x = y;
            }
        }

        res = new ArrayList<>();

        topologySort();

        if (res.size() != N)
            sb.append("0\n");
        else {
            for (int r : res)
                sb.append(r).append("\n");
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                Q.offer(i);
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            res.add(now);

            for (int next : adj[now]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    Q.offer(next);
            }
        }
    }
}
