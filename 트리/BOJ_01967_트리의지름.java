/**
 * BOJ : 1967 G4 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01967_트리의지름 {

    static int N, start, res;
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

        start = 1;

        res = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start, 0);

        res = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
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
