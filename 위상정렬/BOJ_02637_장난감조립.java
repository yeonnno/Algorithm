/**
 * BOJ : 2637 G2 장난감 조립
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02637_장난감조립 {

    static int N, M;
    static int[] indegreeX, indegreeY, res;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        indegreeX = new int[N + 1];
        indegreeY = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            adj[x].add(new Node(y, k));
            indegreeX[x]++;
            indegreeY[y]++;
        }

        res = new int[N + 1];

        topologySort();

        for (int i = 1; i <= N; i++) {
            if (indegreeX[i] == 0)
                sb.append(i).append(" ").append(res[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(N, 1));

        res[N] = 1;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            for (Node next : adj[now.e]) {
                res[next.e] += res[now.e] * next.cnt;
                indegreeY[next.e]--;

                if (indegreeY[next.e] == 0)
                    Q.offer(new Node(next.e, res[next.e]));
            }
        }
    }

    private static class Node {
        int e;
        int cnt;

        public Node(int e, int cnt) {
            this.e = e;
            this.cnt = cnt;
        }
    }
}
