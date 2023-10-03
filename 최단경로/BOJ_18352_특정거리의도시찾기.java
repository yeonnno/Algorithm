/**
 * BOJ : 18352 S2 특정 거리의 도시 찾기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
        }

        visited = new boolean[N + 1];
        
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
        dist[X] = 0;
        BFS(X);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
                cnt++;
            }
        }

        if (cnt == 0) System.out.println(-1);
        else System.out.println(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (!visited[next] && dist[next] == -1) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    Q.add(next);
                }
            }
        }
    }
}
