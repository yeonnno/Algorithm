/**
 * BOJ : 1260 S2 DFS와 BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01260_DFS와BFS {

    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void DFS(int now) {
        visited[now] = true;
        System.out.print(now + " ");

        for (int i = 0; i < adj[now].size(); i++) {
            int next = adj[now].get(i);

            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            System.out.print(now + " ");

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    Q.add(next);
                }
            }
        }
    }
}
