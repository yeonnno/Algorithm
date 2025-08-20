/**
 * BOJ : 24482 S2 깊이 우선 탐색 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24482_깊이우선탐색4 {

    static int N, M, R;
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

        res = new int[N + 1];
        Arrays.fill(res, -1);

        DFS(R, 0);

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append("\n");

        System.out.print(sb);
    }

    private static void DFS(int now, int depth) {
        res[now] = depth;

        for (int next : adj[now]) {
            if (res[next] != -1) continue;

            DFS(next, depth + 1);
        }
    }
}
