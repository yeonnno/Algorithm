/**
 * BOJ : 1707 G4 이분 그래프
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01707_이분그래프 {

    static int V, E;
    static int[] node;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                adj[s].add(e);
                adj[e].add(s);
            }

            boolean check = true;
            node = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                if (!check) break;
                if (node[i] == 0)
                    check = BFS(i);
            }

            if (check) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }

    private static boolean BFS(int idx) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(idx);

        node[idx] = 1;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : adj[now]) {
                if (node[now] == node[next]) return false;

                if (node[next] == 0) {
                    node[next] = node[now] * -1;
                    Q.offer(next);
                }
            }
        }

        return true;
    }
}
