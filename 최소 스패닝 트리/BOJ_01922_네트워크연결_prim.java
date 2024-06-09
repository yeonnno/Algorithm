/**
 * BOJ : 1922 G4 네트워크 연결
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * Prim 풀이
 */
public class BOJ_01922_네트워크연결_prim {

    static int N, M, res;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, cost));
            adj[e].add(new Node(s, cost));
        }

        res = 0;
        visited = new boolean[N + 1];

        prim();

        System.out.println(res);
    }

    private static void prim() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(1, 0));

        while (!PQ.isEmpty()) {
            Node now = PQ.poll();

            if (visited[now.e]) continue;

            visited[now.e] = true;
            res += now.cost;

            for (Node next : adj[now.e]) {
                if (!visited[next.e])
                    PQ.offer(next);
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
