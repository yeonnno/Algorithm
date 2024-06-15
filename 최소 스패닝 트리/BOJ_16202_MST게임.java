/**
 * BOJ : 16202 G3 MST 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16202_MST게임 {

    static int N, M, K, score;
    static int[] parent, res;
    static ArrayList<Node> list;
    static Queue<Node> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y, i));
        }

        res = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            parent = new int[N + 1];
            for (int j = 1; j <= N; j++)
                parent[j] = j;

            Q = new LinkedList<>();
            for (int j = i - 1; j < M; j++)
                Q.offer(list.get(j));

            score = 0;

            kruskal();

            if (check()) res[i] = score;
            else break;
        }

        for (int i = 1; i <= K; i++)
            sb.append(res[i]).append(" ");

        System.out.println(sb);
    }

    private static boolean check() {
        int tmp = find(1);
        for (int i = 2; i <= N; i++) {
            if (tmp != find(i)) return false;
        }
        return true;
    }

    private static void kruskal() {
        while (!Q.isEmpty()) {
            Node node = Q.poll();

            if (find(node.x) == find(node.y)) continue;

            score += node.cost;
            union(node.x, node.y);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
