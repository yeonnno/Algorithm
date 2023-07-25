/**
 * BOJ : 13023 G5 ABCDE
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

    static int N, M;
    static boolean check;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        check = false;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i, 0);
            visited[i] = false;
            if (check) break;
        }

        if (check) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(int now, int depth) {
        if (depth == 4) {
            check = true;
            return;
        }

        for (int next : adj[now]) {
            if (!visited[next]) {
                visited[next] = true;
                DFS(next, depth + 1);
                visited[next] = false;

                if (check) break;
            }
        }
    }
}
