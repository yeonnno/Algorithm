/**
 * BOJ : 24446 S2 너비 우선 탐색 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24446_너비우선탐색3 {

    static int N, M, R;
    static int[] res;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

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

        res = new int[N + 1];
        Arrays.fill(res, -1);

        BFS(R);

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append("\n");

        System.out.print(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        int depth = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int now = Q.poll();

                if (res[now] != -1) continue;
                res[now] = depth;

                for (int next : adj[now]) {
                    if (res[next] != -1) continue;

                    Q.offer(next);
                }
            }

            depth++;
        }
    }
}
