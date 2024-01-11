/**
 * BOJ : 18352 S2 특정 거리의 도시 찾기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

    static int N, M, K, X, INF = 999999999;
    static ArrayList<Integer>[] adj;
    static int[] dist;

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

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        dijkstra(X);

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
                check = true;
            }
        }

        if (check) System.out.print(sb);
        else System.out.println(-1);
    }

    private static void dijkstra(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : adj[now]) {
                if (dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    Q.add(next);
                }
            }
        }
    }
}
