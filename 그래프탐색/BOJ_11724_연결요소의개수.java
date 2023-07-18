/**
 * BOJ : 11724 S2 연결 요소의 개수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

    static int N, M, res;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

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
            adj[e].add(s);
        }

        res = 0;
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                res++;
                BFS(i);
            }
        }

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
                    Q.add(next);
                }
            }
        }
    }
}
