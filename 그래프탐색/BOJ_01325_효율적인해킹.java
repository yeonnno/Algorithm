/**
 * BOJ : 1325 S1 효율적인 해킹
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01325_효율적인해킹 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (max == count[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.add(start);

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    count[next]++;
                    Q.add(next);
                }
            }
        }
    }
}
