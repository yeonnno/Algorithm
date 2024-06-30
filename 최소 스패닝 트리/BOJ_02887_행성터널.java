/**
 * BOJ : 2887 P5 행성 터널
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_02887_행성터널 {

    static int N;
    static long res;
    static int[] parent;
    static ArrayList<int[]> list;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new int[] {i, x, y, z});
        }

        PQ = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++) {
            int x = i;
            Collections.sort(list, (o1, o2) -> o1[x] - o2[x]);

            for (int j = 1; j < N; j++) {
                int[] p1 = list.get(j - 1);
                int[] p2 = list.get(j);
                int cost = Math.abs(p1[i] - p2[i]);

                PQ.offer(new Node(p1[0], p2[0], cost));
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;

        res = 0;

        kruskal();

        System.out.println(res);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (find(node.x) == find(node.y)) continue;

            res += node.cost;
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
