/**
 * BOJ : 1240 G5 노드사이의 거리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01240_노드사이의거리 {

    static int N, M, res;
    static boolean[] visited;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[x].add(new Node(y, cost));
            adj[y].add(new Node(x, cost));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            res = 0;
            visited = new boolean[N + 1];

            DFS(x, y, 0);

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void DFS(int now, int end, int sum) {
        if (now == end) {
            res = sum;
            return;
        }

        visited[now] = true;

        for (Node next : adj[now]) {
            if (visited[next.x]) continue;

            DFS(next.x, end, sum + next.cost);
        }
    }

    private static class Node {
        int x, cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
