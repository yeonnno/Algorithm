/**
 * BOJ : 2252 G3 줄 세우기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02252_줄세우기 {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            indegree[b]++;
        }

        topologySort();

        System.out.println(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                Q.offer(i);
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();

            sb.append(now).append(" ");

            for (int next : adj[now]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    Q.offer(next);
            }
        }
    }
}
