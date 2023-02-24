/**
 * BOJ : 2606 S3 바이러스
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_02606_바이러스 {

    static int V, E, res;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[V + 1];
        res = 0;
        BFS(1);

        System.out.println(res);
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    res++;
                    Q.add(next);
                }
            }
        }
    }
}
