package 그래프탐색;
/**
 * BOJ : 11725 S2 트리의 부모 찾기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visited[v] = true;
        Q.add(v);

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    Q.add(next);
                }
            }
        }
    }
}
