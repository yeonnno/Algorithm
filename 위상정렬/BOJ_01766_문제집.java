/**
 * BOJ : 1766 G2 문제집
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01766_문제집 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            indegree[b]++;
        }

        topologySort();
    }

    private static void topologySort() {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 1; i--) {
            if (indegree[i] == 0)
                PQ.offer(i);
        }

        while (!PQ.isEmpty()) {
            int now = PQ.poll();

            sb.append(now).append(" ");

            for (int next : adj[now]) {
                indegree[next]--;
                if (indegree[next] == 0)
                    PQ.offer(next);
            }
        }

        System.out.println(sb);
    }
}
