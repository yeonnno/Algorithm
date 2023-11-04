/**
 * BOJ : 11779 G3 최소비용 구하기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {

    static int N, M, S, E, INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist, check;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        check = new int[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[S] = 0;
        visited = new boolean[N + 1];

        dijkstra();

        stack = new Stack<>();
        stack.push(E);
        int idx = E;

        while (true) {
            if (check[idx] == S) break;

            stack.push(check[idx]);
            idx = check[idx];
        }
        stack.push(S);

        sb.append(dist[E]).append("\n").append(stack.size()).append("\n");
        while (true) {
            if (stack.size() == 0) break;

            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(S, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Node next : adj[now.e]) {
                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    PQ.add(new Node(next.e, dist[next.e]));
                    check[next.e] = now.e;
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
