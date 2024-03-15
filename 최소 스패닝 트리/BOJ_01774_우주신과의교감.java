/**
 * BOJ : 1774 G3 우주신과의 교감
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01774_우주신과의교감 {

    static int N, M;
    static double res;
    static int[] parent;
    static Point[] points;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;

            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i, x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        PQ = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = distance(points[i], points[j]);

                PQ.offer(new Node(points[i].idx, points[j].idx, dist));
            }
        }

        res = 0;

        kruskal();

        System.out.println(String.format("%.2f", res));
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

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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

    private static class Point {
        int idx;
        double x;
        double y;

        Point(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    private static class Node implements Comparable<Node> {
        int s;
        int e;
        double cost;

        Node(int s, int e, double cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost < o.cost) return -1;
            return 1;
        }
    }
}
