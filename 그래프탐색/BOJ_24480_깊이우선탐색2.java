/**
 * BOJ : 24480 S2 깊이 우선 탐색 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480_깊이우선탐색2 {

    static int N, M, R, cnt;
    static int[] res;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(adj[i], Collections.reverseOrder());

        cnt = 1;
        res = new int[N + 1];

        DFS(R);

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append("\n");

        System.out.print(sb);
    }

    private static void DFS(int now) {
        res[now] = cnt++;

        for (int next : adj[now]) {
            if (res[next] != 0) continue;

            DFS(next);
        }
    }
}
