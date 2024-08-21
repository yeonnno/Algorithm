/**
 * BOJ : 1595 G4 북쪽나라의 도로
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01595_북쪽나라의도로 {

    static final int N = 10001;
    static int start, res;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++)
            tree[i] = new ArrayList<>();

        while (true) {
            int x, y, cost;

            try {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());

                tree[x].add(new Node(y, cost));
                tree[y].add(new Node(x, cost));
            } catch (Exception e) {
                break;
            }
        }

        start = 1;

        res = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        DFS(start, 0);

        res = Integer.MIN_VALUE;
        visited = new boolean[N];
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
