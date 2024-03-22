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

        int total = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = s.charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    map[i][j] = ch - 'a' + 1;
                } else if (ch >= 'A' && ch <= 'Z') {
                    map[i][j] = ch - 'A' + 27;
                } else {
                    map[i][j] = 0;
                }
                total += map[i][j];
            }
        }

        PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (map[i][j] == 0) continue;

                PQ.offer(new Node(i, j, map[i][j]));
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        res = 0;

        kruskal();

        int tmp = find(0);
        boolean check = true;
        for (int i = 1; i < N; i++) {
            if (tmp != find(i)) {
                check = false;
                break;
            }
        }

        if (check) System.out.println(total - res);
        else System.out.println(-1);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            int x = find(node.s);
            int y = find(node.e);

            if (isSameParent(x, y)) continue;

            res += node.cost;
            union(node.s, node.e);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
