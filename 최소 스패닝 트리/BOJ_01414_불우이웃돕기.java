/**
 * BOJ : 1414 G3 불우이웃돕기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_01414_불우이웃돕기 {

    static int N, res;
    static int[] parent;
    static int[][] map;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = s.charAt(j);

                if (ch >= 'a' && ch <= 'z')
                    map[i][j] = ch - 'a' + 1;
                else if (ch >= 'A' && ch <= 'Z')
                    map[i][j] = ch - 'A' + 27;
                else
                    map[i][j] = 0;

                res += map[i][j];
            }
        }

        PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || map[i][j] == 0) continue;

                PQ.offer(new Node(i, j, map[i][j]));
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;

        kruskal();

        if (checkParent()) System.out.println(res);
        else System.out.println(-1);
    }

    private static boolean checkParent() {
        int tmp = find(0);
        for (int i = 1; i < N; i++) {
            if (tmp != find(i)) return false;
        }
        return true;
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            res -= node.cost;
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

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
