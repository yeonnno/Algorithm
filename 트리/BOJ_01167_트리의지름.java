/**
 * BOJ : 1167 G2 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01167_트리의지름 {

    static int V, start, res;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                int y = Integer.parseInt(st.nextToken());

                if (y == -1) break;

                int cost = Integer.parseInt(st.nextToken());

                tree[x].add(new Node(y, cost));
                tree[y].add(new Node(x, cost));
            }
        }

        start = 1;

        res = Integer.MIN_VALUE;
        visited = new boolean[V + 1];
        visited[start] = true;
        DFS(start, 0);

        res = Integer.MIN_VALUE;
        visited = new boolean[V + 1];
        visited[start] = true;
        DFS(start, 0);

        System.out.println(res);
    }

    private static void DFS(int now, int sum) {
        if (res < sum) {
            res = sum;
            start = now;
        }

        for (Node next : tree[now]) {
            if (visited[next.x]) continue;

            visited[next.x] = true;
            DFS(next.x, sum + next.cost);
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
