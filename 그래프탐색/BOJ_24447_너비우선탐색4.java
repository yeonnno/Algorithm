/**
 * BOJ : 24447 S2 너비 우선 탐색 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24447_너비우선탐색4 {

    static int N, M, R;
    static long[] seq, dep;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

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
            Collections.sort(adj[i]);

        seq = new long[N + 1];
        dep = new long[N + 1];
        Arrays.fill(dep, -1);

        BFS(R);

        long res = 0;
        for (int i = 1; i <= N; i++)
            res += seq[i] * dep[i];

        System.out.println(res);
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        int sequence = 1, depth = 0;

        seq[start] = sequence++;
        dep[start] = depth++;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int now = Q.poll();


                for (int next : adj[now]) {
                    if (dep[next] != -1) continue;

                    seq[next] = sequence++;
                    dep[next] = depth;

                    Q.offer(next);
                }
            }

            depth++;
        }
    }
}
