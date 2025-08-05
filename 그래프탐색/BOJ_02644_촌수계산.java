/**
 * BOJ : 2644 S2 촌수계산
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_02644_촌수계산 {

    static int N, M, res;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        res = -1;
        visited = new boolean[N + 1];

        DFS(x, y, 0);

        System.out.println(res);
    }

    private static void DFS(int now, int end, int cnt) {
        if (now == end) {
            res = cnt;
            return;
        }

        visited[now] = true;

        for (int next : adj[now]) {
            if (visited[next]) continue;

            DFS(next, end, cnt + 1);
        }
    }
}
