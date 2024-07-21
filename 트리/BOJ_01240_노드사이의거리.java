/**
 * BOJ : 1240 G5 노드사이의 거리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01240_노드사이의거리 {

    static int N, M, res;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[x].add(new Node(y, cost));
            tree[y].add(new Node(x, cost));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            res = 0;

            BFS(x, y);

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void BFS(int start, int end) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(start, 0));

        visited = new boolean[N + 1];
        visited[start] = true;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            if (now.x == end) {
                res = now.cost;
                return;
            }

            for (Node next : tree[now.x]) {
                if (visited[next.x]) continue;

                visited[next.x] = true;
                Q.offer(new Node(next.x, now.cost + next.cost));
            }
        }
    }

    private static class Node {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
