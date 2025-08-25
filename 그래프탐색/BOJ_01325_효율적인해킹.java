/**
 * BOJ : 1325 S1 효율적인 해킹
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01325_효율적인해킹 {

    static int N, M;
    static int[] count;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[e].add(s);
        }

        count = new int[N + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int cnt = 1;

            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);

            visited = new boolean[N + 1];
            visited[i] = true;

            while (!Q.isEmpty()) {
                int now = Q.poll();

                for (int next : adj[now]) {
                    if (visited[next]) continue;

                    visited[next] = true;
                    cnt++;
                    Q.offer(next);
                }
            }

            count[i] = cnt;
            if (max < cnt)
                max = cnt;
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
