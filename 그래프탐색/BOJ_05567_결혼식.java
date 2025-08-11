/**
 * BOJ : 5567 S2 결혼식
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_05567_결혼식 {

    static int N, M, res;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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

        visited = new boolean[N + 1];
        visited[1] = true;

        DFS(0, 1);

        res = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i])
                res++;
        }
        System.out.println(res);
    }

    private static void DFS(int depth, int now) {
        if (depth == 3)
            return;


        for (int next : adj[now]) {
            visited[now] = true;
            DFS(depth + 1, next);
        }
    }
}
