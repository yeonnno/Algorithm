/**
 * BOJ : 13418 G3 학교 탐방하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13418_학교탐방하기 {

    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> PQ1, PQ2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PQ1 = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
        PQ2 = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            PQ1.offer(new Node(s, e, 1 ^ cost));
            PQ2.offer(new Node(s, e, 1 ^ cost));
        }

        int res1 = kruskal(PQ1);
        int res2 = kruskal(PQ2);

        System.out.println(res1 * res1 - res2 * res2);
    }

    private static int kruskal(PriorityQueue<Node> PQ) {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            int x = find(node.s);
            int y = find(node.e);

            if (isSameParent(x, y)) continue;

            cnt += node.cost;
            union(node.s, node.e);
        }

        return cnt;
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

    private static class Node {
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
