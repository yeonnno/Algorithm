/**
 * BOJ : 19581 P5 두 번째 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19581_두번째트리의지름 {

    static int N;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

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

        Node endA = BFS(1, 0);
        Node endB = BFS(endA.x, 0);

        int resA = BFS(endA.x, endB.x).cost;
        int resB = BFS(endB.x, endA.x).cost;

        System.out.println(Math.max(resA, resB));
    }

    private static Node BFS(int start, int end) {
        Queue<Node> Q = new LinkedList<>();
        Node node = new Node(start, 0);
        Q.offer(node);

        visited = new boolean[N + 1];
        visited[start] = true;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            if (now.cost > node.cost && now.x != end)
                node = now;

            for (Node next : tree[now.x]) {
                if (visited[next.x]) continue;

                visited[next.x] = true;
                Q.offer(new Node(next.x, now.cost + next.cost));
            }
        }

        return node;
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
