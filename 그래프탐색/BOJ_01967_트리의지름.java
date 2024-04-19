/**
 * BOJ : 1967 G4 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01967_트리의지름 {

    static int N, start, max;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, cost));
            adj[e].add(new Node(s, cost));
        }

        start = 1;

        max = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start, 0);

        max = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start, 0);

        System.out.println(max);
    }

    private static void DFS(int node, int sum) {
        if (max < sum) {
            max = sum;
            start = node;
        }

        for (Node next : adj[node]) {
            if (visited[next.e]) continue;

            visited[next.e] = true;
            DFS(next.e, sum + next.cost);
        }
    }

    private static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
