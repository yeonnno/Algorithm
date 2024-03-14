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

    static int N, M, K, min;
    static ArrayList<Node>[] list;
    static Queue<Node> Q;
    static int[] parent, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[M + 1];
        for (int i = 0; i <= M; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[i].add(new Node(s, e, i));
        }

        res = new int[K];
        for (int i = 0; i < K; i++) {
            Q = new LinkedList<>();
            for (int j = i + 1; j <= M; j++) {
                Q.offer(list[j].get(0));
            }

            parent = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                parent[j] = j;
            }

            min = 0;

            kruskal();

            boolean check = true;
            int tmp = find(1);
            for (int j = 2; j <= N; j++) {
                if (tmp != find(j)) check = false;
            }

            if (check) res[i] = min;
            else break;
        }

        for (int r : res) sb.append(r).append(" ");

        System.out.println(sb);
    }

    private static void kruskal() {
        while (!Q.isEmpty()) {
            Node node = Q.poll();

            int x = find(node.s);
            int y = find(node.e);

            if (isSameParent(x, y)) continue;

            min += node.cost;
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
