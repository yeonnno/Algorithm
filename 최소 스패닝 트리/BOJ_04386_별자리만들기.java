/**
 * BOJ : 4386 G3 별자리 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_04386_별자리만들기 {

    static int N;
    static int[] parent;
    static Point[] points;
    static PriorityQueue<Node> PQ;
    static double res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;

            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i, x, y);
        }

        PQ = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = distance(points[i], points[j]);

                PQ.add(new Node(points[i].idx, points[j].idx, dist));
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

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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
            else return 1;
        }
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
}
